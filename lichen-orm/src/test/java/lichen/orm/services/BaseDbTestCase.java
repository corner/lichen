package lichen.orm.services;

import lichen.orm.LichenOrmModule;
import lichen.orm.entity.UserEntity;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Startup;
import org.apache.tapestry5.ioc.test.IOCTestCase;
import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import sun.tools.jconsole.Plotter;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 基于数据库的测试
 * @author jcai
 * @version 0.1
 */
public class BaseDbTestCase{
    private Registry registry;
    @Before
    public void setupContainer(){
        registry = buildRegistry(LichenOrmModule.class,MemoryDatabaseModule.class);
        registry.performRegistryStartup();
    }
    protected <T> T getService(Class<T> serviceInterface){
        return registry.getService(serviceInterface);
    }
    @After
    public void shutdownContainer(){
       registry.shutdown();
    }
    public static class MemoryDatabaseModule{
        @Startup
        public static void initDb(DataSource ds,HibernateSessionManager sessionManager,
               HibernateOperations hibernateOperations,PlatformTransactionManager transaction) throws SQLException, HibernateException {
            JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);
            Dialect dialect = Dialect.getDialect(sessionManager.getConfiguration().getProperties());
            DatabaseMetadata metadata= new DatabaseMetadata(jdbcTemplate.getDataSource().getConnection(), dialect);
            String [] sql = sessionManager.getConfiguration().generateDropSchemaScript(dialect);
            try{
                for(String s:sql)
                    jdbcTemplate.execute(s);
            }catch(Exception e){}
            sql=sessionManager.getConfiguration().generateSchemaCreationScript(dialect);
            try{
                for(String s:sql)
                    jdbcTemplate.execute(s);
            }catch(Exception e){}

            //init data
            hibernateOperations.save(new UserEntity());
        }
        public static void contributeAnnotationEntityPackageManager(Configuration<String> configuration){
            configuration.add("lichen.orm.entity");
        }
    }
    /**
     * Builds a Registry for the provided modules; caller should shutdown the Registry when done.
     */
    protected final Registry buildRegistry(Class... moduleClasses)
    {
        RegistryBuilder builder = new RegistryBuilder();

        builder.add(moduleClasses);

        return builder.build();
    }
}
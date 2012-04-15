package lichen.ws.app;

import lichen.ws.WsModule;
import lichen.ws.internal.EmbeddedAxis2Servlet;
import org.apache.tapestry5.TapestryFilter;
import org.apache.tapestry5.internal.InternalConstants;
import org.apache.tapestry5.ioc.Registry;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.*;
import org.mortbay.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jcai
 */
public class LichenWsApp{

    private static Context contextHandler;
    private static Logger logger = LoggerFactory.getLogger(LichenWsApp.class);
    public static void  main(String [] args) throws Exception {
        System.setProperty("tapestry.modules", WsModule.class.getName());
        contextHandler = new Context();
        contextHandler.setContextPath("/");

        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put(InternalConstants.TAPESTRY_APP_PACKAGE_PARAM, "lichen.ws");
        contextHandler.setInitParams(initParams);

        ServletHandler handler = contextHandler.getServletHandler();

        //axis2 servlet
        ServletHolder axisServlet = new ServletHolder(EmbeddedAxis2Servlet.class);
        axisServlet.setName("axis2");
        handler.addServletWithMapping(axisServlet, "/services/*");

        //filter holder
        FilterHolder filterHolder = new FilterHolder(TapestryFilter.class);
        filterHolder.setName("monad");
        handler.addFilterWithMapping(filterHolder, "/*", Handler.ALL);


        Server server = new Server();
        server.setSendServerVersion(false);
        //thread pool
        QueuedThreadPool tp = new QueuedThreadPool();
        tp.setMinThreads(10);
        tp.setMaxThreads(2000);
        tp.setLowThreads(20);
        tp.setSpawnOrShrinkAt(2);
        server.setThreadPool(tp);

        //connector
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(8080);
        connector.setMaxIdleTime(30000);
        connector.setAcceptors(5);
        connector.setStatsOn(false);
        connector.setLowResourcesConnections(5000);
        //connector.setLowResourcesMaxIdleTime(5000)
        server.addConnector(connector);
        server.setHandler(contextHandler);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    getRegistry().shutdown();
                } finally {
                    logger.info("Server closed!");
                }
            }
        });

        server.start();
        server.join();
    }
    private static Registry getRegistry(){
        return (Registry) contextHandler.getServletContext().getAttribute(TapestryFilter.REGISTRY_CONTEXT_NAME);
    }
}

package com.egfit.lichen.orm.model;

import org.apache.tapestry5.func.F;
import org.apache.tapestry5.func.Flow;
import org.apache.tapestry5.func.Reducer;

/**
 * ��ѯ�ķ�װ
 * @author jcai
 */
public class QueryRelation {
	private Flow<QlFrame> whereQl;
	private final Reducer<StringBuilder,QlFrame> whereReducer = new WhereQlReducer();

	public QueryRelation(){
		this.whereQl= F.flow();
	}
	/**
	 * ����һ��qlƬ�Σ����뵽�������.
	 * 
	 * <code>
	 * QueryRelation qr = ...
	 * qr.where("name='jcai'");
	 * </code>
	 * 
	 * @param ql ��ѯ���Ƭ��
	 * @return ��ѯ����
	 */
	public QueryRelation where(String ql){
		whereQl=whereQl.append(new WhereQlFrame(ql));
		return this;
	}
	void produceWhereCondition(StringBuilder sb){
		if(whereQl.count() > 0 ){
			sb.append("where 1=1");
			whereQl.reduce(whereReducer, sb);
		}
	}
	interface QlFrame{
		String toSql();
	}
	class WhereQlReducer implements Reducer<StringBuilder,QlFrame>{
		public StringBuilder reduce(StringBuilder accumulator, QlFrame value) {
			return accumulator.append(" and ").append(value.toSql());
		}
	}
	class BeginWhereQlFrame implements QlFrame{

		public String toSql() {
				return " where 1=1";
		}
		
	}
	class WhereQlFrame implements QlFrame{
		private String sql;
		WhereQlFrame(String sql){
			this.sql = sql;
		}
		public String toSql(){
			return sql;
		}
	}
}

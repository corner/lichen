/*		
 * Copyright 2010 The EGF Co,. Ltd. 
 * site: http://www.egfit.com
 * file: $Id: ServiceCategory.java 283 2010-03-11 07:41:26Z jcai $
 * created at:2010-2-6
 */
package lichen.ws.model;

/**
 * service category
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 283 $
 * @since 0.1
 */
public enum ServiceCategory {
	QUERY("查询类"), NONE("未分类");
	private String categroyName;
	private ServiceCategory(String categoryName){
		this.categroyName = categoryName;
	}
	/**
	 * @return the categroyName
	 */
	public String getCategroyName() {
		return categroyName;
	}
}

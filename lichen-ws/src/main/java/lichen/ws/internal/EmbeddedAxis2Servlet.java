/*		
 * Copyright 2010 The EGF Co,. Ltd. 
 * site: http://www.egfit.com
 * file: $Id: EmbeddedAxis2Servlet.java 283 2010-03-11 07:41:26Z jcai $
 * created at:2010-3-5
 */
package lichen.ws.internal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import lichen.ws.service.WebServicePublisher;
import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.AxisServlet;
import org.apache.tapestry5.TapestryFilter;
import org.apache.tapestry5.ioc.Registry;


/**
 * embedded service servlet
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 283 $
 * @since 0.1
 */
public class EmbeddedAxis2Servlet extends AxisServlet{
	private static final long serialVersionUID = 5186545795908822464L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			//add tapestry ioc object supplier
			axisConfiguration.addParameter("ServiceObjectSupplier", TapestryIOCObjectSupplier.class.getName());
			//get ioc registry object
			Registry registry = (Registry) config.getServletContext().getAttribute(TapestryFilter.REGISTRY_CONTEXT_NAME);
			//publish  service object annotioned by @WebService
			WebServicePublisher publisher = registry.getService(WebServicePublisher.class);
			publisher.registryWebServiceObject(axisConfiguration);
		} catch (AxisFault e) {
			throw new RuntimeException(e);
		}
	}
}

/*		
 * Copyright 2010 The EGF Co,. Ltd. 
 * site: http://www.egfit.com
 * file: $Id: WsModule.java 283 2010-03-11 07:41:26Z jcai $
 * created at:2010-2-7
 */
package lichen.ws;

import lichen.ws.internal.EchoServiceImpl;
import lichen.ws.internal.WebServicePublisherImpl;
import lichen.ws.service.EchoService;
import lichen.ws.service.WebServicePublisher;
import org.apache.tapestry5.ioc.ServiceBinder;


/**
 * web service module
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 283 $
 * @since 0.1
 */
public class WsModule {
	public static void bind(ServiceBinder binder){
		binder.bind(WebServicePublisher.class,WebServicePublisherImpl.class);
		//only for test webservice
		binder.bind(EchoService.class,EchoServiceImpl.class);
	}
}

package lichen.ws.internal;

import org.apache.tapestry5.ioc.services.ServiceActivityScoreboard;
import org.easymock.EasyMock;
import org.junit.Test;

/**
 * @author jcai
 */
public class WebServicePublisherImplTest {
    @Test
    public void test_publish(){
        ServiceActivityScoreboard serviceActivityScoreboard = EasyMock.createMock(ServiceActivityScoreboard.class);
        WebServicePublisherImpl webServicePublisher = new WebServicePublisherImpl(serviceActivityScoreboard);

    }
}

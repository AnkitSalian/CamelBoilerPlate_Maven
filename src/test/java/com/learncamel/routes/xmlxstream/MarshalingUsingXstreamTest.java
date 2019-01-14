package com.learncamel.routes.xmlxstream;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalingUsingXstreamTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new MarshalingUsingXstream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {
        String input = "1234,Ankit,TCS";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><com.learncamel.domain.Employee><id>1234</id><name>Ankit</name><company>TCS</company></com.learncamel.domain.Employee>";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:csvInput",input);
        assertMockEndpointsSatisfied();
    }

    @Test
    public void marshalXstreamTestEmployeeAlias() throws InterruptedException {
        String input = "1234,Ankit,TCS";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><id>1234</id><name>Ankit</name><company>TCS</company></employee>";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:csvInput",input);
        assertMockEndpointsSatisfied();
    }

}

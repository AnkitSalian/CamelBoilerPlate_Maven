package com.learncamel.routes.transform;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyTransformRoute();
    }

    @Test
    public void transformTest() throws InterruptedException{
        String input = "1234,Ankit,TCS";
        String expected = "1234*Ankit*TCS";
        String actual = (String) template.requestBody("direct:transformInput",input);
        assertEquals(expected,actual);
    }

    @Test
    public void transformUsingMock() throws InterruptedException{
        String input = "1234,Ankit,TCS";
        String expected = "1234*Ankit*TCS";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:transformInput",input);
        assertMockEndpointsSatisfied();
    }
}

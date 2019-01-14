package com.learncamel.routes.process;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest() throws InterruptedException{
        String input = "1234,Ankit,TCS";
        String expected = "1234:Ankit:TCS";
        String output = (String) template.requestBody("direct:processorInput",input);
        assertEquals(expected,output);
    }

    @Test
    public void processorDirectUsingMock() throws InterruptedException{
        String expected = "1234:Ankit:TCS";
        String input = "1234,Ankit,TCS";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:processorInput", input);
        assertMockEndpointsSatisfied();
    }
}

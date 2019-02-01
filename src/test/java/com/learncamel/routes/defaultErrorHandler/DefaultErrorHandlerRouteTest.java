package com.learncamel.routes.defaultErrorHandler;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck(){
        String expectedOutput="1234*Ankit*1Feb2019";
        String input = null;
        String output = template.requestBody("direct:exception",input,String.class);
        assertEquals(expectedOutput,output);
    }

}

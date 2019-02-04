package com.learncamel.routes.onException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void onExceptionCheck(){
        String request = null;
        final String response = template.requestBody("direct:exception",request,String.class);

    }

    @Test
    public void onExceptionCheckHandled(){
        String request = null;
        String expectedOutput = "Exception happened in the route";
        final String response = template.requestBody("direct:exception",request,String.class);
        System.out.println("Response is===>"+response);
        assertEquals(expectedOutput,response);
    }

    @Test
    public void onExceptionCheckIgnore(){
        String request = null;
        String expectedOutput = null;
        final String response = template.requestBody("direct:exception",request,String.class);
        System.out.println("Response is===>"+response);
        assertEquals(expectedOutput,response);
    }
}

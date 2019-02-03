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
}

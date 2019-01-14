package com.learncamel.routes.bean;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTest(){
        String expected = "1234*Ankit*TCS";
        String input = "1234,Ankit,TCS";
        String actual = (String) template.requestBody("direct:beanInput",input);
        assertEquals(expected,actual);
    }

}

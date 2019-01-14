package com.learncamel.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new XML2JSONRoute();
    }

    @Test
    public void marshalEmployeeXml2Json(){
        String input="<?xml version='1.0' encoding='UTF-8'?><employee><id>1234</id><name>Ankit</name><company>TCS</company></employee>";
        String expected = "{\"id\":\"1234\",\"name\":\"Ankit\",\"company\":\"TCS\"}";
        String response = template.requestBody("direct:marshalEmployeeXml2Json",input,String.class);
        System.out.println("Response===>"+response);
        assertEquals(expected,response);
    }

    @Test
    public void unMarshalEmployeeJson2Xml(){
        String expected="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><company>TCS</company><id>1234</id><name>Ankit</name></employee>\r\n";
        String input = "{\"id\":\"1234\",\"name\":\"Ankit\",\"company\":\"TCS\"}";
        String response = template.requestBody("direct:unMarshalEmployeeJson2Xml",input,String.class);
        System.out.println("Response===>"+response);
        assertEquals(expected,response);
    }

}

package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new MarshalUsingGson();
    }

    @Test
    public void marshalGsonTest(){
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Ankit");
        employee.setCompany("TCS");

        String expectedJson="{\"id\":\"1\",\"name\":\"Ankit\",\"company\":\"TCS\"}";
        String resultJson = template.requestBody("direct:marshalGson", employee, String.class);
        System.out.println("Employee Json==>"+resultJson);
        assertEquals(expectedJson,resultJson);
    }
}

package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import com.learncamel.routes.xml2json.UnmarshalUsingGson;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingGsonTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new UnmarshalUsingGson();
    }

    @Test
    public void unmarshalGson(){
        String input="{\"id\":\"1\",\"name\":\"Ankit\",\"company\":\"TCS\"}";
        Employee employee = template.requestBody("direct:unmarshalGson",input,Employee.class);
        assertEquals("1",employee.getId());
        assertEquals("Ankit",employee.getName());
        assertEquals("TCS",employee.getCompany());
    }

}

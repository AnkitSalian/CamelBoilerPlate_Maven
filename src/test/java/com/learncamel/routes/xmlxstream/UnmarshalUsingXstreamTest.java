package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import com.learncamel.xmlxstream.UnmarshalUsingXstream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new UnmarshalUsingXstream();
    }

    @Test
    public void unmarshalXtreamTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setId("1234");
        employee.setName("Ankit");
        employee.setCompany("TCS");

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(employee.toString());

        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>1234</id><name>Ankit</name><company>TCS</company></employee>";
        template.sendBody("direct:xmlInput",input);
        assertMockEndpointsSatisfied();

    }

}

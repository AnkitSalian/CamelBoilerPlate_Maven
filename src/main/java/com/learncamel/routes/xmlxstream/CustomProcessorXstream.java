package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class CustomProcessorXstream implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        String newBody = exchange.getIn().getBody(String.class);
        StringTokenizer token = new StringTokenizer(newBody,",");

        Employee employee = new Employee();
        while (token.hasMoreElements()){
            employee.setId((String) token.nextElement());
            employee.setName((String) token.nextElement());
            employee.setCompany((String) token.nextElement());
        }
        exchange.getIn().setBody(employee);
    }
}

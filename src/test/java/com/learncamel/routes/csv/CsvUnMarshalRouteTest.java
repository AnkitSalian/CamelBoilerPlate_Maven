package com.learncamel.routes.csv;

import com.learncamel.domain.Person;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CsvUnMarshalRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CsvUnMarshalRoute();
    }

    @Test
    public void csvUnMarshalRoute() throws InterruptedException{
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);
        List<Person> person = (List<Person>) exchange.getIn().getBody();
        assertEquals("Ankit",person.get(0).getFirstName());
        assertEquals("Anit",person.get(1).getFirstName());
    }

}

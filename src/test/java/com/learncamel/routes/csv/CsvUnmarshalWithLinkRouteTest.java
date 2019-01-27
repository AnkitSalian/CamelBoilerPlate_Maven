package com.learncamel.routes.csv;

import com.learncamel.domain.PersonWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvUnmarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CsvUnmarshalWithLinkRoute();
    }

    @Test
    public void unmarshalCsvUsingLink() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(3000);
        PersonWithAddress personWithAddress = (PersonWithAddress) exchange.getIn().getBody();
        System.out.println("personWithAddress===>"+personWithAddress);
        assertEquals("India",personWithAddress.getAddress().getCountry());
    }

}

package com.learncamel.routes.csv;

import com.learncamel.domain.Address;
import com.learncamel.domain.PersonWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CsvMarshalWithLinkRouteTest extends CamelTestSupport {

    public RouteBuilder createRouteBuilder(){
        return new CsvMarshalWithLinkRoute();
    }

    @Test
    public void marshalCsvWithLinkRoute() throws InterruptedException {
        PersonWithAddress personWithAddress = new PersonWithAddress();
        personWithAddress.setId("1");
        personWithAddress.setFirstName("Ankit");
        personWithAddress.setLastName("Salian");
        Address address = new Address();
        address.setAddressLine("BARC Colony");
        address.setCity("Mumbai");
        address.setCountry("India");
        address.setState("Maharashtra");
        personWithAddress.setAddress(address);
        template.sendBody("direct:objInput",personWithAddress);

        Thread.sleep(3000);
        File file = new File("data/csv/output/outputWithAddress.txt");
        assertTrue(file.exists());
    }

}

package com.learncamel.routes.fixedLength;

import com.learncamel.domain.PersonWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedLengthMarshalCamelRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new FixedLengthMarshalCamelRoute();
    }

    @Test
    public void fixedLengthMarshalTest() throws InterruptedException {
        PersonWithFixedLength personWithFixedLength = new PersonWithFixedLength();
        personWithFixedLength.setId("123");
        personWithFixedLength.setName("Ankit");
        personWithFixedLength.setRole("Engineer");
        personWithFixedLength.setDate(LocalDate.now());
        personWithFixedLength.setAge(24);
        personWithFixedLength.setSalary(new BigDecimal("33000.00"));

        template.sendBody("direct:input",personWithFixedLength);
        Thread.sleep(3000);
        File file = new File("data/fixedLength/output");
        assertTrue(file.isDirectory());

    }

}

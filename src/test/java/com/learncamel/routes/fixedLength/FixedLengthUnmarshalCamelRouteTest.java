package com.learncamel.routes.fixedLength;

import com.learncamel.domain.PersonWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FixedLengthUnmarshalCamelRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new FixedLengthUnmarshalCamelRoute();
    }

    @Test
    public void unmarshalFixedLengthFile(){

        Exchange exchange = consumer.receive("direct:output");
        List<PersonWithFixedLength> personWithFixedLengthList = (List<PersonWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(personWithFixedLengthList);
        assertEquals("ankit",personWithFixedLengthList.get(0).getName());
        assertEquals("ashok",personWithFixedLengthList.get(1).getName());
        LocalDate expectedDate =  LocalDate.of(2019,01,28);
        LocalDate expectedDate1 =  LocalDate.of(2018,01,28);
        assertEquals(expectedDate.getYear(),personWithFixedLengthList.get(0).getDate().getYear());
        assertEquals(expectedDate1.getYear(),personWithFixedLengthList.get(1).getDate().getYear());
        assertEquals(24,personWithFixedLengthList.get(0).getAge());
        assertEquals(54,personWithFixedLengthList.get(1).getAge());
        BigDecimal expectedAnkitSalary = new BigDecimal("33000.00");
        BigDecimal expectedAshokSalary = new BigDecimal("45000.00");
        assertEquals(expectedAnkitSalary,personWithFixedLengthList.get(0).getSalary());
        assertEquals(expectedAshokSalary,personWithFixedLengthList.get(1).getSalary());

    }

}

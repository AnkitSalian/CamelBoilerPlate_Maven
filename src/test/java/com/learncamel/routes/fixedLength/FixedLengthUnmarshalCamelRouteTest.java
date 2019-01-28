package com.learncamel.routes.fixedLength;

import com.learncamel.domain.PersonWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

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

    }

}

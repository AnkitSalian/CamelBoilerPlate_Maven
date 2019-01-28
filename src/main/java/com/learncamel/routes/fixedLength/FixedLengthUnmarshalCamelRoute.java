package com.learncamel.routes.fixedLength;

import com.learncamel.domain.PersonWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthUnmarshalCamelRoute extends RouteBuilder {
    public void configure() throws Exception {

        DataFormat bindy = new BindyFixedLengthDataFormat(PersonWithFixedLength.class);

        from("file:data/fixedLength/input?fileName=fixedLength.txt&noop=true")
                .unmarshal(bindy)
                .log("Unmarshaled message is ${body}")
                .to("direct:output");

    }
}

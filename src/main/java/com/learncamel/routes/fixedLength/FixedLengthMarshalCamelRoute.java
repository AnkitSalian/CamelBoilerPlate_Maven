package com.learncamel.routes.fixedLength;

import com.learncamel.domain.PersonWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthMarshalCamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(PersonWithFixedLength.class);
        from("direct:input")
                .marshal(bindy)
                .log("Marshalled msg is ${body}")
                .to("file:data/fixedLength/output?fileName=output.txt");
    }
}

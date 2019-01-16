package com.learncamel.routes.csv;

import com.learncamel.domain.PersonWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvMarshalWithLinkRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(PersonWithAddress.class);
        from("file:data/csv/input?fileName=fileWithAddress.txt&noop=true")
                .log("Received Msg is ${body}")
                .unmarshal(bindy)
                .log("Unmarshaled msg is ${body}")
                .to("direct:output");
    }
}

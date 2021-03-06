package com.learncamel.routes.csv;

import com.learncamel.domain.PersonWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvMarshalWithLinkRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(PersonWithAddress.class);
        from("direct:objInput")
                .marshal(bindy)
                .log("Marshalled message is ${body}")
                .to("file:data/csv/output?fileName=outputWithAddress.txt");
    }
}

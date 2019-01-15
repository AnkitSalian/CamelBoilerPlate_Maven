package com.learncamel.routes.csv;

import com.learncamel.domain.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvUnMarshalRoute extends RouteBuilder {

    public void configure() throws Exception{
        DataFormat bindy = new BindyCsvDataFormat(Person.class);
        from("file:data/csv?fileName=file.txt&noop=true")
                .log("Before unmarshaled message is ${body}")
                .unmarshal(bindy)
                .log("Unmarshaled message is ${body}")
                .to("direct:output");
    }

}

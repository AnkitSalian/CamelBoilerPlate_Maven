package com.learncamel.routes.xml2json;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnmarshalUsingGson extends RouteBuilder {
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
        from("direct:unmarshalGson")
                .log("Received message body is ${body}")
                .unmarshal(gsonDataFormat)
                .log("Unmarshaled body is ${body}");
    }
}

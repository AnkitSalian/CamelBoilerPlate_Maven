package com.learncamel.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnmarshalUsingXstream extends RouteBuilder {
    public void configure() throws Exception {
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String,String> alias = new HashMap<String, String>();
        alias.put("employee", Employee.class.getName());
        xStreamDataFormat.setAliases(alias);
        xStreamDataFormat.setPermissions(Employee.class.getName());

        from("direct:xmlInput")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");

    }
}

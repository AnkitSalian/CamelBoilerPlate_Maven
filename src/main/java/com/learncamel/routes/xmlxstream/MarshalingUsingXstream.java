package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalingUsingXstream extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:csvInput")
                .process(new CustomProcessorXstream())
                //.marshal().xstream()
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateStreamDef(){
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String,String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());
        xStreamDataFormat.setAliases(aliases);
        return xStreamDataFormat;
    }
}

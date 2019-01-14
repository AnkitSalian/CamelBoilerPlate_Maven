package com.learncamel.routes.process;

import com.learncamel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Read message body before processing ${body} and headers is ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Read message body after processing ${body} and headers is ${headers}")
                .to("file:data/output")
                .to("mock:output");
    }
}

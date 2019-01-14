package com.learncamel.routes.process;

import com.learncamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Read file body i.e. ${body} and headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}

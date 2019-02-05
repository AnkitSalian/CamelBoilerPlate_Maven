package com.learncamel.routes.eips.multiCast;

import org.apache.camel.builder.RouteBuilder;

public class MultiCast extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/eips?noop=true")
                .multicast().stopOnException()
                .parallelProcessing()
                .to("file:data/output1","file:data/output2");

        /*from("file:data/eips?noop=true")//Performs same operation as above but multicast provides additional features
                .to("file:data/output1")
                .to("file:data/output2");*/
    }
}

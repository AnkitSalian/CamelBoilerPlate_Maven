package com.learncamel.routes.eips.wireTap;

import org.apache.camel.builder.RouteBuilder;

public class WireTapRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/eips?noop=true")
                .wireTap("file:data/debug")
                .to("file:data/wireTapAll");
    }
}

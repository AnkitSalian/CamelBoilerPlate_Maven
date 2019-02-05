package com.learncamel.routes.eips.contentBasedRouter;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouterRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/eips?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                    .when(header("CamelFileNameConsumed").endsWith(".html"))
                        .to("file:data/html")
                    .when(header("CamelFileNameConsumed").endsWith(".txt"))
                        .to("file:data/text")
                    .when(header("CamelFileNameConsumed").endsWith(".json"))
                        .to("file:data/json")
                    .otherwise()
                        .to("file:data/others");
    }
}

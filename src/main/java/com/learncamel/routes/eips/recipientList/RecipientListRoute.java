package com.learncamel.routes.eips.recipientList;

import com.learncamel.processor.RecipientEIPProcessor;
import org.apache.camel.builder.RouteBuilder;

public class RecipientListRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/xmlInput?noop=true")
                .setHeader("type",xpath("employee/@type"))
                .process(new RecipientEIPProcessor())
                .recipientList(header("type"));
    }
}

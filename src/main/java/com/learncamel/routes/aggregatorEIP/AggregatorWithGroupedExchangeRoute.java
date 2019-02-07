package com.learncamel.routes.aggregatorEIP;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class AggregatorWithGroupedExchangeRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:grpAggregator")
                .log("Received message is ${body} and headers are ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                .completionSize(3)
                .log("Aggregated message is ${body}")
                .to("mock:output");
    }
}

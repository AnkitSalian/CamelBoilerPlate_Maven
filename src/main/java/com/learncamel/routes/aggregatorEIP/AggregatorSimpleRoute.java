package com.learncamel.routes.aggregatorEIP;

import com.learncamel.aggregate.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorSimpleRoute extends RouteBuilder {
    //1
    //2
    //3

    //123

    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received message is ${body} and key{header.aggregatorId}")
                .aggregate(header("aggregatorId"),new AggregatorSimpleRouteStrategy()).completionSize(3)
                .log("Aggregated message is ${body}")
                .to("mock:output");
    }
}

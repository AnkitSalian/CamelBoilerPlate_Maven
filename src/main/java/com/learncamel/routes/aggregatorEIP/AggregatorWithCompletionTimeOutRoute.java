package com.learncamel.routes.aggregatorEIP;

import com.learncamel.aggregate.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorWithCompletionTimeOutRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received message body is ${body} and the headers key is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy())
                .completionSize(3).completionTimeout(3000)
                .log("Aggregated message is ${body}")
                .to("mock:output");
    }
}

package com.learncamel.routes.aggregatorEIP;

import com.learncamel.aggregate.AggregatorPredicateStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorCompletionPredicate extends RouteBuilder {
    public void configure() throws Exception{
        from("direct:completionPredicate")
                .log("Received message body is ${body} and the header key is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorPredicateStrategy())
                .completionPredicate(body().contains("order-confirm")).eagerCheckCompletion()
                .log("Final message is ${body}")
                .to("mock:output");
    }
}

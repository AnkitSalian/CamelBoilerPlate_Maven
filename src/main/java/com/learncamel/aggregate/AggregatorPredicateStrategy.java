package com.learncamel.aggregate;

import org.apache.camel.Exchange;

public class AggregatorPredicateStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if(oldExchange==null){
            return newExchange;
        }else {
            String oldBody = (String) oldExchange.getIn().getBody();
            String newBody = (String) newExchange.getIn().getBody();
            newBody=oldBody.concat(":").concat(newBody);
            newExchange.getIn().setBody(newBody);
            return newExchange;
        }
    }
}

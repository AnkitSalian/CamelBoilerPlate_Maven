package com.learncamel.routes.aggregatorEIP;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorCompletionPredicateTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new AggregatorCompletionPredicate();
    }

    @Test
    public void predicateTest() throws InterruptedException {
        String orderCreate = "12345,car,order-created";
        String orderConfirm = "12345,car,order-confirm";
        String expectedOutcome = orderCreate.concat(":").concat(orderConfirm);
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedOutcome);

        template.sendBodyAndHeader("direct:completionPredicate",orderCreate,"aggregatorId",12345);
        template.sendBodyAndHeader("direct:completionPredicate",orderConfirm,"aggregatorId",12345);

        assertMockEndpointsSatisfied();
    }
}

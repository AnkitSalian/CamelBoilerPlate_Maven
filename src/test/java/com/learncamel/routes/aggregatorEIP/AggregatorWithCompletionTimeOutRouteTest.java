package com.learncamel.routes.aggregatorEIP;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorWithCompletionTimeOutRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new AggregatorWithCompletionTimeOutRoute();
    }

    @Test
    public void aggregateTimeout() throws InterruptedException{

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived("12");

        template.sendBodyAndHeader("direct:simpleAggregator","1","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","2","aggregatorId",1);
        Thread.sleep(5000);
        template.sendBodyAndHeader("direct:simpleAggregator","4","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","3","aggregatorId",1);

        assertMockEndpointsSatisfied();
    }
}

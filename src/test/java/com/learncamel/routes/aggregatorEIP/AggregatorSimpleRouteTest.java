package com.learncamel.routes.aggregatorEIP;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorSimpleRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new AggregatorSimpleRoute();
    }

    @Test
    public void aggregateSimpleTest() throws InterruptedException {
        MockEndpoint mockEndpoint =getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simpleAggregator","1","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","2","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","4","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","3","aggregatorId",1);
        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMultipleMessage() throws InterruptedException {
        List<String> expectedValueList = new ArrayList<String>();
        expectedValueList.add("123");
        expectedValueList.add("567");
        MockEndpoint mockEndpoint =getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader("direct:simpleAggregator","1","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","2","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","4","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","3","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","5","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","6","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","7","aggregatorId",1);
        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMultipleMessage_DifferentAggregator() throws InterruptedException {
        List<String> expectedValueList = new ArrayList<String>();
        expectedValueList.add("123");
        expectedValueList.add("567");
        MockEndpoint mockEndpoint =getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader("direct:simpleAggregator","1","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","2","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","4","aggregatorId",3);
        template.sendBodyAndHeader("direct:simpleAggregator","3","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","5","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","6","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","7","aggregatorId",2);
        assertMockEndpointsSatisfied();
    }
}

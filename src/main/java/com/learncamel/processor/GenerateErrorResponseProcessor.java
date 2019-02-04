package com.learncamel.processor;

import org.apache.camel.Exchange;

public class GenerateErrorResponseProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT,Exception.class);
        System.out.println("Actual exception message===>"+e.getLocalizedMessage());
        System.out.println("Actual exception class===>"+e.getClass());

        String failedEndpoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint===>"+failedEndpoint);
        exchange.getIn().setBody("Exception happened in the route");
    }
}

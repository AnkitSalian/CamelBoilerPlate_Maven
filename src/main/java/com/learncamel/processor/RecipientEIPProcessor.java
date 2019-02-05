package com.learncamel.processor;

import org.apache.camel.Exchange;

public class RecipientEIPProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String employeeType = exchange.getIn().getHeader("type",String.class);
        if(employeeType.equals("senior")){
            exchange.getIn().setHeader("type","file:data/xmlsenior");
        }else if(employeeType.equals("junior")){
            exchange.getIn().setHeader("type","file:data/xmljunior");
        }
    }
}

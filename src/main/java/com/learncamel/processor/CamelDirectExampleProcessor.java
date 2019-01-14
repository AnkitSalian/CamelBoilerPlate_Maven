package com.learncamel.processor;

import org.apache.camel.Exchange;

public class CamelDirectExampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        try{
            String oldValue = (String) exchange.getIn().getBody();
            String newValue = oldValue.replace(",",":");
            exchange.getIn().setBody(newValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

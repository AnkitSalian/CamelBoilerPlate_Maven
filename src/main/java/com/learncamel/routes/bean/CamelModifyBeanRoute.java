package com.learncamel.routes.bean;

import com.learncamel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Before bean body is ${body}")
                .bean(new CamelBean(),"map")
                .log("After bean body is ${body}")
                .to("mock:output");
    }
}

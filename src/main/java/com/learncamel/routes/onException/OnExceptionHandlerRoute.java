package com.learncamel.routes.onException;

import com.learncamel.bean.DataModifier;
import com.learncamel.processor.GenerateErrorResponseProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.sql.SQLException;

public class OnExceptionHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //onException(RuntimeException.class,Exception.class).log(LoggingLevel.INFO,"Exception in Bean caught here");
        //onException(SQLException.class).log(LoggingLevel.ERROR,"Exception in Bean caught here");

        //With Re-delivery and redleivery delay
         //onException(RuntimeException.class,Exception.class).maximumRedeliveries(2).redeliveryDelay(5000).backOffMultiplier(2).log(LoggingLevel.WARN, "Exception in Processor caught here");

        //with Redelivery and Handled
        onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new GenerateErrorResponseProcessor()).log(LoggingLevel.WARN, "Exception in Processor caught here");

        from("direct:exception")
                .bean(new DataModifier(),"mapOnException")
                .log("log:?level=INFO&showBody=true");
    }
}

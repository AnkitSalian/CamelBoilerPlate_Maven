package com.learncamel.routes.eips.recipientList;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class RecipientListRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new RecipientListRoute();
    }

    @Test
    public void recipientListTest() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/xmlsenior");
        assertTrue(file.isDirectory());
        File file1 = new File("data/xmljunior");
        assertTrue(file1.isDirectory());
    }
}

package com.learncamel.routes.eips.contentBasedRouter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBasedRouterRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new ContentBasedRouterRoute();
    }

    @Test
    public void contentBasedRouterTest() throws InterruptedException{
        Thread.sleep(5000);
        File file = new File("data/html");
        assertTrue(file.isDirectory());
        File file1 = new File("data/text");
        assertTrue(file1.isDirectory());
        File file2 = new File("data/json");
        assertTrue(file2.isDirectory());
        File file3 = new File("data/others");
        assertTrue(file3.isDirectory());
    }
}

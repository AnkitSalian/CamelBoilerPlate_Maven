package com.learncamel.routes.eips.wireTap;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class WireTapRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new WireTapRoute();
    }

    @Test
    public void wireTapRoute() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/wireTapAll");
        assertTrue(file.isDirectory());
        File file1 = new File("data/debug");
        assertTrue(file1.isDirectory());
    }
}

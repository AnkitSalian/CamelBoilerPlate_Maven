package com.learncamel.routes.eips.contentBasedRouter;

import com.learncamel.routes.eips.multiCast.MultiCast;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class MultiCastTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new MultiCast();
    }

    @Test
    public void multiCastRouteTest() throws InterruptedException{
        Thread.sleep(5000);
        File file = new File("data/output1");
        assertTrue(file.isDirectory());
        File file1 = new File("data/output2");
        assertTrue(file1.isDirectory());
    }
}

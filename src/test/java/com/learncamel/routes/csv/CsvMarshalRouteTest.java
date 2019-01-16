package com.learncamel.routes.csv;

import com.learncamel.domain.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvMarshalRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CsvMarshalRoute();
    }

    @Test
    public void csvMarshalRoute(){
        Person person = new Person();
        person.setId("1");
        person.setFirstName("Ankit");
        person.setLastName("Salian");

        Person person1 = new Person();
        person1.setId("2");
        person1.setFirstName("Anit");
        person1.setLastName("Salian");

        List<Person> personList = new ArrayList<Person>();
        personList.add(person);
        personList.add(person1);

        template.sendBody("direct:objInput",personList);

        File file = new File("data/csv/output");
        assertTrue(file.isDirectory());
    }

}

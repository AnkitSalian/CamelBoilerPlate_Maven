package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.math.BigDecimal;
import java.time.LocalDate;

@FixedLengthRecord(ignoreTrailingChars = true)
public class PersonWithFixedLength {

    @DataField(pos = 1, length = 3)
    private String id;

    @DataField(pos = 2, length = 6, trim = true, align = "L")
    private String name;

    @DataField(pos = 3, length = 8)
    private String role;

    @DataField(pos = 4, length = 9, pattern = "ddMMMyyyy")
    private LocalDate date;

    @DataField(pos=5, delimiter = "^")
    private int age;

    @DataField(pos=6,length = 6, precision = 2)
    private BigDecimal salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PersonWithFixedLength{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", date=" + date +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

package com.learncamel.bean;

public class CamelBean {

    public String map (String input){
        String newBody = input.replace(",","*");
        return newBody;
    }

}

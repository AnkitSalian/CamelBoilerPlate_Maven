package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;

public class Address {

    @DataField(pos = 4)
    private String addressLine;
    @DataField(pos = 5)
    private String city;
    @DataField(pos = 6)
    private String state;
    @DataField(pos = 7)
    private String country;

    @Override
    public String toString() {
        return "Address{" +
                "addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

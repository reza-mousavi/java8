package com.lector.reza.sample.java8.model;

import java.io.Serializable;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/22/2016
 */
public class Company implements Serializable{

    private String name;
    private String website;
    private String phoneNumber;
    private Company partner;

    public Company(String name, String website, String phoneNumber, Company partner) {
        this.name = name;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Company getPartner() {
        return partner;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("name='").append(name).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static Company DIMLER = new Company("Dimler", "www.dimler.com", "121315", null);
    public static Company BMW = new Company("BMW", "www.bmw.com", "7777", null);
    public static Company SAB = new Company("BMW", "www.bmw.com", "7777", null);
    public static Company IKCO = new Company("IKCO", "www.ikco.com", "7777", DIMLER);

}

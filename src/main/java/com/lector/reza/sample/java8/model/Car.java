package com.lector.reza.sample.java8.model;

import java.io.Serializable;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/22/2016
 */
public class Car implements Serializable{

    private String model;
    private Integer productionYear;
    private Company company;

    public Car(String model, Integer productionYear, Company company) {
        this.model = model;
        this.productionYear = productionYear;
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("model='").append(model).append('\'');
        sb.append(", productionYear=").append(productionYear);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }
}

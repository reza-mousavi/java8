package com.lector.reza.sample.java8.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/21/2016
 */
public class Person implements Serializable{

    private String name;
    private int age;
    private List<Car> carList;

    public Person(String name, int age) {
        this(name, age, null);
    }

    public Person(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.carList = cars;
    }

    public String getName() {
        return name;
    }

    public boolean isElderly() {
        return age > 44;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getAge() {
        return age;
    }

    public String getOnLocation(int x, int y) {
        return "Person on location (x): " + x + ", (y): " + toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public static String format(Person person) {
        if (person.isElderly()) {
            return "Elderly : " + person;
        }
        return "Young : " + person;
    }

    private static String getInfoLog(String string) {
        return "Person is : " + string;
    }

}

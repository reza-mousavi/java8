package com.lector.reza.sample.java8.model;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/21/2016
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public boolean isElderly() {
        return age > 44;
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

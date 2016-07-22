package com.lector.reza.sample.java8;

import com.lector.reza.sample.java8.model.Car;
import com.lector.reza.sample.java8.model.Company;
import com.lector.reza.sample.java8.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/22/2016
 */
public class OptionalInteraction {

    public static void main(String[] args) {
        final Car car1 = new Car("X6", 2015, Company.BMW);
        final Car car2 = new Car("X3", 2017, Company.BMW);
        final Car car3 = new Car("SAMAND", 2010, Company.IKCO);
        final Car car4 = new Car("S500", 2012, Company.DIMLER);

        final Person reza = new Person("Reza Mousavi", 31, Arrays.asList(car1, car2, car3, car4));
        final Person mona = new Person("Mona Yazdan", 29);
        final Person alex = new Person("Alex Riis", 30, Arrays.asList(car1, car4));

        Stream.of(reza, mona, alex)
                .map(OptionalInteraction::getCarCompanyNames)
                .map(e -> "Car name(s) is/are : " + e)
                .forEach(System.out::println);

        Stream.of(reza, mona, alex)
                .map(e -> "Newest Car model for " + e.getName() + " is : " + OptionalInteraction.getNewestModel(e))
                .forEach(System.out::println);
    }

    private static String getCarCompanyNames(Person person) {
        return Optional
                .ofNullable(person)
                .map(Person::getCarList)
                .orElse(new ArrayList<>())
                .stream()
                .map(Car::getCompany)
                .map(Company::getName)
                .distinct()
                .collect(Collectors.joining("#"));
    }

    private static Integer getNewestModel(Person person) {
        return Optional
                .ofNullable(person)
                .map(Person::getCarList)
                .orElse(new ArrayList<>())
                .stream()
                .mapToInt(Car::getProductionYear)
                .max()
                .orElse(-9999);
    }

}

package com.lector.reza.sample.java8;

import com.lector.reza.sample.java8.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

/**
 * Created by REM on 20-06-2016.
 */
public class Main {
    public static void main(String[] args) {

    }

    private static void rangeTest() {
        final long before = System.currentTimeMillis();
        LongStream.range(1, 10_000_000_000L)
                .parallel()
                .map(i -> i /2)
                .map(j -> j+5)
                .average();
        final long after = System.currentTimeMillis();
        System.out.println("Took (ms) : " + (after - before));
    }

    private static void declarativeStreamManipulation() {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Reza Mousavi", 31));
        persons.add(new Person("Mona Yazdanpanah", 29));
        persons.add(new Person("Alex Riis", 37));
        persons.add(new Person("Kim kardashian", 45));

        Predicate<Person> isElderly = Person::isElderly;
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(isElderly.negate())
                .map(person -> "Person is : " + person)
                .forEach(System.out::println);
    }

}
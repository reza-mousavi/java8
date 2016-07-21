package com.lector.reza.sample.java8;

import com.lector.reza.sample.java8.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * Created by REM on 20-06-2016.
 */
public class MethodReference {

    private static final Logger logger = Logger.getLogger(MethodReference.class.getName());

    public static void main(String[] args) {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Reza Mousavi", 31));
        persons.add(new Person("Mona Yazdan", 28));
        persons.add(new Person("Alex Riis", 35));
        persons.add(new Person("James Adam", 55));
        persons.add(new Person("Robert Nilson", 63));
        persons.add(new Person("Mark Anthony", 12));

        final int x = 10, y = 15;

        persons.stream()
                .peek((Person p) -> logInfo(p, (s) -> "Reza" + s))
                .filter(Person::isElderly)
                .peek((e) -> e.getOnLocation(x, y))
                .map(Person::toString)
                .forEach(logger::info);
    }

    private static <T> void logInfo(T t, Function<T, String> consumer){
        logger.info(consumer.apply(t));
    }

}
package com.lector.reza.sample.java8;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/21/2016
 */
public class BasicFlow {

    private static final String NEW_LINE = "\r\n";
    private static final String SPACE = " ";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        //printWordFromNumber();
        //printIntendedRectangle();
    }

    private static void printMixedTriangleDesc() {
        final int rows = 5;
        final String result = getMixedTriAngleDesc(rows, String::valueOf);
        System.out.println("Rectangle : " + rows);
        System.out.println(result);
    }

    private static void printMixedTriangleAcs() {
        final int rows = 5;
        final String result = getMixedTriAngleAsc(rows, String::valueOf);
        System.out.println("Rectangle : " + rows);
        System.out.println(result);
    }

    private static void printTriangleDesc() {
        final int rows = 5;
        final String result = getTriAngleDesc(rows, String::valueOf);
        System.out.println("Rectangle : " + rows);
        System.out.println(result);
    }

    private static void printTriangleAcs() {
        final int rows = 5;
        final String result = getTriAngleAsc(rows, e -> "#");
        System.out.println("Rectangle : " + rows);
        System.out.println(result);
    }

    private static void printRectangle() {
        final int rows = 5;
        final int columns = 6;
        final String result = getRectangle(rows, columns, e -> "*");
        System.out.println("Rectangle : " + rows + " , columns : " + columns);
        System.out.println(result);
    }

    private static void printIntendedRectangle() {
        final int rows = 5;
        final int columns = 6;
        final String result = getIntendedRectangle(rows, columns, String::valueOf);
        System.out.println("Rectangle : " + rows + " , columns : " + columns);
        System.out.println(result);
    }

    private static String getMixedTriAngleAsc(int rows, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i ->
                        IntStream.rangeClosed(1, rows)
                                .mapToObj(j -> j < (rows - i + 1) ? SPACE : mapper.apply(j))
                                .collect(Collectors.joining(SPACE))
                )
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String getMixedTriAngleDesc(int rows, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i ->
                        IntStream.rangeClosed(1, rows)
                                .mapToObj(j -> j > (rows - i + 1) ? SPACE : mapper.apply(j))
                                .collect(Collectors.joining(SPACE))
                )
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String getTriAngleAsc(int rows, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i ->
                        IntStream.rangeClosed(1, i)
                                .mapToObj(mapper)
                                .collect(Collectors.joining(SPACE))
                )
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String getTriAngleDesc(int rows, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i ->
                        IntStream.rangeClosed(1, rows - i + 1)
                                .mapToObj(mapper)
                                .collect(Collectors.joining(SPACE))
                )
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String getRectangle(int rows, int columns, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i ->
                        IntStream.rangeClosed(1, columns)
                                .mapToObj(mapper)
                                .collect(Collectors.joining(SPACE))
                )
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String getIntendedRectangle(int rows, int columns, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i ->
                        IntStream.rangeClosed(1, columns)
                                .mapToObj(mapper)
                                .collect(Collectors.joining(SPACE, (i % 2) == 0 ? EMPTY : SPACE, EMPTY))
                )
                .collect(Collectors.joining(NEW_LINE));
    }

    public static String getLineFiledWithStart(int columns, IntFunction<String> mapper) {
        return IntStream.rangeClosed(1, columns)
                .mapToObj(mapper)
                .collect(Collectors.joining(SPACE));

    }

    private static void printPI() {
        final Long terms = 5000000000L;
        final double pi = calculatePI(terms);
        System.out.println("PI number for terms : " + terms + " is : " + pi);
    }

    private static double calculatePI(Long terms) {
        final double summation = getFilteredRange(1, terms, isNotEvenPredicate())
                .map(i -> (i % 4 == 3) ? -i : i)
                .mapToDouble(i -> 1 / (double) i)
                .sum();
        return summation * 4;
    }

    private static void printHermonic(Long boundary) {
        final long before = System.currentTimeMillis();
        double hermonic;
        if (boundary < 5000) {
            hermonic = caluclateHermonicS(boundary);
        } else {
            hermonic = caluclateHermonicP(boundary);
        }
        final long after = System.currentTimeMillis();
        System.out.println("Hermonic R2L for : " + boundary + " is : " + hermonic + " , in (ms) : " + (after - before));
    }

    private static double caluclateHermonicP(Long boundary) {
        return LongStream.range(1, boundary)
                .parallel()
                .mapToDouble(i -> 1 / (double) i)
                .sum();
    }

    private static double caluclateHermonicS(Long boundary) {
        return LongStream.range(1, boundary)
                .sequential()
                .mapToDouble(i -> 1 / (double) i)
                .sum();
    }

    private static void printProduction(long start, long end) {
        final Long production = production(start, end);
        System.out.println("Count of : " + start + " to : " + end + " is : " + production);
    }

    private static void printStatistics(int start, int end) {
        final IntSummaryStatistics statistics = IntStream.range(start, end)
                .summaryStatistics();
        System.out.println("Count from : " + start + " to : " + end + " is : " + statistics.getCount());
        System.out.println("Sum from : " + start + " to : " + end + " is : " + statistics.getSum());
        System.out.println("Average from : " + start + " to : " + end + " is : " + statistics.getAverage());
    }

    private static void printWordFromNumber() {
        IntStream.range(1, 20)
                .mapToObj(BasicFlow::getWord)
                .map(e -> "String value is : " + e)
                .forEach(System.out::println);
    }

    final static private Map<Integer, String> NUMBERS_MAP;

    static {
        NUMBERS_MAP = new HashMap<>();

        NUMBERS_MAP.put(1, "ONE");
        NUMBERS_MAP.put(2, "TWO");
        NUMBERS_MAP.put(3, "THREE");
        NUMBERS_MAP.put(4, "FOUR");
        NUMBERS_MAP.put(5, "FIVE");
        NUMBERS_MAP.put(6, "SIX");
        NUMBERS_MAP.put(7, "SEVEN");
        NUMBERS_MAP.put(8, "EIGHT");
        NUMBERS_MAP.put(9, "NINE");
    }

    private static String getWord(int number) {
        return Optional.of(number)
                .map(NUMBERS_MAP::get)
                .orElse("UNKNOWN");
    }

    private static Long factorial(int n) {
        return production(1, n);
    }

    private static Long production(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .reduce(1, (a, b) -> a * b);
    }

    private static void printEvenNumbers(long start, long end) {
        printFilteredNumbers(start, end, isEvenPredicate());
    }

    private static void printOddNumbers(long start, long end) {
        printFilteredNumbers(start, end, isNotEvenPredicate());
    }

    private static void printFilteredNumbers(long start, long end, LongPredicate predicate) {
        getFilteredRange(start, end, predicate)
                .mapToObj(evenNumber -> "Number is : " + evenNumber)
                .forEach(System.out::println);
    }

    private static LongStream getFilteredRange(long start, long end, LongPredicate predicate) {
        if ((end - start) < 100000) {
            return LongStream.range(start, end)
                    .sequential()
                    .filter(predicate);
        }
        return LongStream.range(start, end)
                .parallel()
                .filter(predicate);
    }

    private static LongPredicate isNotEvenPredicate() {
        return isEvenPredicate().negate();
    }

    private static LongPredicate isEvenPredicate() {
        return BasicFlow::isEven;
    }

    private static boolean isNotEven(long number) {
        return !isEven(number);
    }

    private static boolean isEven(long number) {
        return number % 2 == 0;
    }
}


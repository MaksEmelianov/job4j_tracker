package ru.job4j.api;

import java.util.stream.Stream;

public class TakeAndDropWhile {

    public static void main(String[] args) {
        Stream.of(1, 2, null, 3, 4)
                .flatMap(Stream::ofNullable)
                .takeWhile(integer -> integer < 3)
                .map(integer -> "Result: " + integer)
                .forEach(System.out::println);
        Stream.of(1, 2, 3, 4)
                .dropWhile(integer -> integer < 3)
                .map(integer -> "Result: " + integer)
                .forEach(System.out::println);
    }
}

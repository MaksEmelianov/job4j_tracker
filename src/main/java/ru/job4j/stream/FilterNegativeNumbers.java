package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 0, -1, -10, 23, 0, 10);
        List<Integer> positive = numbers.stream().filter(
                num -> num > 0
        ).toList();
        positive.forEach(System.out::println);
    }
}

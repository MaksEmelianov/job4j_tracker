package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "asd", "fwfdfsd", "wwq", "fsdsdfsdf");
        Comparator<String> comparator = (o1, o2) -> {
            System.out.println("compare - " + o2.length() + " : " + o1.length());
            return Integer.compare(o2.length(), o1.length());
        };
        strings.sort(comparator);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}

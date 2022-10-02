package ru.job4j.collection;

import java.util.*;
import java.util.stream.Stream;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String tmpStr = "";
            for (String el : value.split("/")) {
                tmpStr = tmpStr.isEmpty() ? el : tmpStr + "/" + el;
                tmp.add(tmpStr);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static List<String> sortAsc(List<String> args) {
        return args.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.naturalOrder())
                .toList();

    }

    public static List<String> sortDesc(List<String> args) {
        return args.stream()
                .flatMap(Stream::ofNullable)
                .sorted(new DepDescComp())
                .toList();
    }
}

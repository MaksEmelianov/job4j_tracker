package ru.job4j.collection;

import java.util.*;

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

    public static void sortAsc(List<String> args) {
        args.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> args) {
        args.sort(new DepDescComp());
    }
}

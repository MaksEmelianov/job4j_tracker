package ru.job4j.collection;

import java.util.*;

public class ListSort {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 2, 6, 8, 3, 7);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Integer first = 1;
        Integer second = 2;
        int rsl = first.compareTo(second);
        System.out.println(rsl);
        String petr = "Petr";
        String ivan = "Ivan";
        int rsl2 = petr.compareTo(ivan);
        System.out.println(rsl2);
        List<Integer> list2 = Arrays.asList(4, 2, 6, 8, 9, 3);
        System.out.println(list2);
        Collections.sort(list2, Collections.reverseOrder());
        /*list2.sort(Collections.reverseOrder());*/
        System.out.println(list2);
    }
}

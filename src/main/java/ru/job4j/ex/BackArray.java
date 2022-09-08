package ru.job4j.ex;

import java.util.Arrays;

public class BackArray {

    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        int middle = names.length / 2;
        for (int index = 0; index < middle; index++) {
            String tmp = names[index];
            names[index] = names[names.length - index - 1];
            names[names.length - index - 1] = tmp;
        }
        System.out.println(Arrays.toString(names));
    }
}

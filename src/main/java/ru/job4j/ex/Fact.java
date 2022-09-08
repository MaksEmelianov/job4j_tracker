package ru.job4j.ex;

public class Fact {

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N could not be less then 0");
        }
        int rsl = 1;
        for (int i = 2; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        new Fact().calc(-1);
    }
}

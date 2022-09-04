package ru.job4j.opp;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int nums) {
        return nums - x;
    }

    public int divide(int nums) {
        return nums / x;
    }

    public int sumAllOperation(int nums) {
        return sum(nums) + multiply(nums) + multiply(nums) + divide(nums);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl;
        rsl = sum(5);
        rsl = calculator.multiply(5);
        rsl = minus(5);
        rsl = calculator.divide(5);
        rsl = calculator.sumAllOperation(5);
        System.out.println(rsl);
    }
}

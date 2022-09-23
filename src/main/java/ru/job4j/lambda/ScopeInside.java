package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int total = 0;
        for (int num : nums) {
            int tmp = total;
            total = add(
                    () -> tmp + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> supplier) {
        return supplier.get();
    }
}

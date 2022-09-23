package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {

    public List<Double> diapason(int start, int end, Function<Double, Double> func){
        List<Double> rsl = new ArrayList<>();
        for (int index = start; index < end; index++) {
            rsl.add(func.apply((double) index));
        }
        return rsl;
    }
}

package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {

    @Test
    void whenLinearFunction() {
        FunctionCalculator calculator = new FunctionCalculator();
        List<Double> rsl = calculator.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11d, 13d, 15d);
        assertThat(rsl).containsAll(expected);
    }

    @Test
    void whenQuadraticFunction() {
        FunctionCalculator calculator = new FunctionCalculator();
        List<Double> rsl = calculator.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = List.of(26d, 37d, 50d);
        assertThat(rsl).containsAll(expected);
    }

    @Test
    void whenExponentialFunction() {
        FunctionCalculator calculator = new FunctionCalculator();
        List<Double> rsl = calculator.diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = List.of(33d, 65d, 129d);
        assertThat(rsl).containsAll(expected);
    }
}

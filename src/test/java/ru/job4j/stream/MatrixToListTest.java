package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixToListTest {

    @Test
    void whenInputSquareMatrix() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> rsl = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(rsl).containsAll(expected);
    }

    @Test
    void whenInputNoSquareMatrix() {
        Integer[][] matrix = {
                {1},
                {4, 5},
                {7, 8, 9}
        };
        List<Integer> rsl = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 4, 5, 7, 8, 9);
        assertThat(rsl).containsAll(expected);
    }
}

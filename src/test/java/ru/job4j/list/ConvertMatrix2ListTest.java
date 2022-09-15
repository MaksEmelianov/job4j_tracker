package ru.job4j.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertMatrix2ListTest {

    @Test
    void when3on3ArrayThenList9() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] in = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3);
        List<Integer> out = list.toList(in);
        assertThat(out).containsAll(expected);
    }

    @Test
    void whenEmptyArray() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] in = {{}};
        List<Integer> out = list.toList(in);
        assertThat(out).isEmpty();
    }
}

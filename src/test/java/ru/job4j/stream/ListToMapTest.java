package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ListToMapTest {

    @Test
    void whenInputListNotHaveDuplicate() {
        List<Student> students = List.of(
                new Student(30, "Ivanov"),
                new Student(40, "Petrov"),
                new Student(50, "Sidorov")
        );
        Map<String, Student> result = ListToMap.convert(students);
        Map<String, Student> expected = new LinkedHashMap<>();
        expected.put("Ivanov", new Student(30, "Ivanov"));
        expected.put("Petrov", new Student(40, "Petrov"));
        expected.put("Sidorov", new Student(50, "Sidorov"));
        assertThat(result).containsAllEntriesOf(expected);
    }

    @Test
    void whenInputListHaveDuplicate() {
        List<Student> students = List.of(
                new Student(30, "Ivanov"),
                new Student(40, "Petrov"),
                new Student(70, "Petrov"),
                new Student(50, "Sidorov"),
                new Student(10, "Sidorov")
        );
        Map<String, Student> result = ListToMap.convert(students);
        Map<String, Student> expected = new LinkedHashMap<>();
        expected.put("Ivanov", new Student(30, "Ivanov"));
        expected.put("Petrov", new Student(40, "Petrov"));
        expected.put("Sidorov", new Student(50, "Sidorov"));
        assertThat(result).containsAllEntriesOf(expected);
    }
}

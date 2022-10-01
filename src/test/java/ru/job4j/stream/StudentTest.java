package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    @Test
    void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = student -> student.getScore() >= 70 && student.getScore() <= 100;
        school.collect(students, predicate);
        List<Student> expected = List.of(
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        assertThat(students).containsAll(expected);
    }

    @Test
    void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = student -> student.getScore() >= 50 && student.getScore() < 70;
        school.collect(students, predicate);
        List<Student> expected = List.of(
                new Student(50, "Surname5")
        );
        assertThat(students).containsAll(expected);
    }

    @Test
    void whenCollectClassC() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = student -> student.getScore() > 0 && student.getScore() < 50;
        school.collect(students, predicate);
        List<Student> expected = List.of(
                new Student(50, "Surname5")
        );
        assertThat(students).containsAll(expected);
    }
}

package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> taskList) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : taskList) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}

package ru.job4j.tracker;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
public class Item implements Comparable<Item> {

    private int id;
    private String name;
    private LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Item(int id, String name, LocalDateTime now) {
        this.id = id;
        this.name = name;
        this.now = now;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    @Override
    public int compareTo(Item o) {
        return name.compareTo(o.name);
    }
}
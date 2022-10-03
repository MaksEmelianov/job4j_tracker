package ru.job4j.map;

import java.util.Objects;

public class Subject {

    private String nameSubject;
    private int score;

    public Subject(String name, int score) {
        this.nameSubject = name;
        this.score = score;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(nameSubject, subject.nameSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSubject);
    }
}

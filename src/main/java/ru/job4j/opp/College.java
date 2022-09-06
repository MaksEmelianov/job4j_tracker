package ru.job4j.opp;

public class College {

    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object objStud = student;
        Object ostud = new Freshman();
        Freshman studFromObj = (Freshman) ostud;
    }
}

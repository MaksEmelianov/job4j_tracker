package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Maksim");
        student.setGroup("New Group 2022");
        student.setCreated(new Date());
        System.out.println(
                "Студент "
                + student.getFio()
                + " поступил в группу: "
                + student.getGroup()
                + " " + student.getCreated());
    }
}

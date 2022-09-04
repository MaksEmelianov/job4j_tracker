package ru.job4j.opp;

public class Student {

    public static void main(String[] args) {
        Student petya = new Student();
        String text = "Tra tra tra";
        for (int i = 0; i < 3; i++) {
            petya.song();
            petya.music(text);
        }
    }

    public void music(String text) {
        System.out.println("I can sign a song : " + text);
    }

    public void song() {
        System.out.println("I believe I can fly");
    }
}

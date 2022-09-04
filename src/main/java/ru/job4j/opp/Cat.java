package ru.job4j.opp;

public class Cat {

    public static void main(String[] args) {
        Cat petty = new Cat();
        Cat sparky = new Cat();
        String say = petty.sound();
        System.out.println("Petty say: " + say);
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }
}

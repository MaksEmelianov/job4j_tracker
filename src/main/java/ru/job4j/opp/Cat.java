package ru.job4j.opp;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.printf("The cat %s ate %s%n", this.name, this.food);
    }

    void eat(String meat) {
        this.food = meat;
    }

    void giveName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveName("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveName("Black");
        black.eat("fish");
        black.show();
        System.out.println("There are nick's food.");
        Cat nick = new Cat();
        nick.giveName("Nick");
        nick.eat("bird");
        nick.show();
    }

    public String sound() {
        return "may-may";
    }
}

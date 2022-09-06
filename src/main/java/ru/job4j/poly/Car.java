package ru.job4j.poly;

public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по дороге");
    }

    @Override
    public void getSpeed() {
        System.out.println("Со скоростью 200 км/ч");
    }
}

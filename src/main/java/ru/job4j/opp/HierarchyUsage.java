package ru.job4j.opp;

public class HierarchyUsage {

    public static void main(String[] args) {
        Car car = new Car();
        Transport tr = car;
        Object obj = car;
        Object ocar = new Car();
        Car carFromObject = (Car) ocar;
    }
}

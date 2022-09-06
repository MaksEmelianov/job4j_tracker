package ru.job4j.poly;

public class PolyUsage {

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{car, plane, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.getSpeed();
        }
    }
}

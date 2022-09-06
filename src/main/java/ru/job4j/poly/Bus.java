package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("В автобусе находится : " + passenger + " пассажиров");
    }

    @Override
    public int refuel(int liters) {
        return liters * 50;
    }
}

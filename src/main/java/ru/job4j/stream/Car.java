package ru.job4j.stream;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String model;
    private String color;
    private LocalDate created;
    private double volume;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", color='" + color + '\''
                + ", created=" + created
                + ", volume=" + volume
                + '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private String color;
        private LocalDate created;
        private double volume;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.color = color;
            car.created = created;
            car.volume = volume;
            return car;
        }
    }

    public static void main(String[] args) {
        Car toyota = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(toyota);

        Car logan = new Builder()
                .buildBrand("Renault")
                .buildModel("Logan")
                .buildCreated(LocalDate.of(2006, 6, 6))
                .buildVolume(3.5)
                .buildColor("Black")
                .build();
        System.out.println(logan);
    }
}

package com.gabriella.itschool.utils.design_patterns;

public class FactoryExample {
}

abstract class Vehicle {
    // ... vehicle common properties and methods
}

class Truck extends Vehicle {
    // ... truck common properties and methods
}

class Car extends Vehicle {
    // ... car common properties and methods
}

class Bicycle extends Vehicle {
    // ... bicycle common properties and methods
}

class VehicleFactory {

    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "truck" -> {
                return new Truck();
            }
            case "car" -> {
                return new Car();
            }
            case "bicycle" -> {
                return new Bicycle();
            }
            default -> throw new IllegalArgumentException("Unknown vehicle type.");
        }
    }
}
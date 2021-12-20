package com.nick.blog.features.java17;

import java.util.Arrays;
import java.util.Objects;

/**
 * A final class cannot be extended, while a non-public class or interface has limited access.
 * Yet, there are times when a class or interface needs to be accessible from anywhere,
 * but be extendable only by a certain class or interface
 * or, in the case of an interface, be implemented only by certain classes).
 * That is the motivation for r sealed classes and interfaces were added to SDK in Java 17.
 *
 * The difference between a sealed class or interface and a final one is that
 * a sealed class or interface always has a keyword permits followed by the list
 * of the existing direct subtypes that are allowed to extend the sealed class or interface
 * or, in the case of interface, implement it.
 *
 * Please, notice the word “existing.” The subtypes listed after the permits keyword
 * must exist at compilation time in the same module as the sealed class
 * or in the same package, if in the default (unnamed) module.
 */
public class SealedClassOrInterface {
    public static void main(String... args) {
        Vehicle vehicle = new Vehicle("Ford", "Taurus", 300);
        System.out.println(vehicle.getClass().isSealed());   //prints: true
        System.out.println(Arrays.stream(vehicle.getClass().getPermittedSubclasses()).map(Objects::toString).toList());
                                                             //prints list of permitted classes

        Car car = new Car("Ford", "Taurus", 300, 4);
        System.out.println(car.getClass().isSealed());                  //prints: false
        System.out.println(car.getClass().getPermittedSubclasses());    //prints: null
    }

    private sealed interface Engine permits EngineBrand, Vehicle {
        int getHorsePower();
    }

    private non-sealed interface EngineBrand extends Engine {
        String getBrand();
    }

    private static sealed class Vehicle implements Engine permits Car, Truck {
        private final String make, model;
        private final int horsePower;
        public Vehicle(String make, String model, int horsePower) {
            this.make = make;
            this.model = model;
            this.horsePower = horsePower;
        }
        public String getMake() { return make; }
        public String getModel() { return model; }
        public int getHorsePower() { return horsePower; }
    }

    private static final class Car extends Vehicle {
        private final int passengerCount;
        public Car(String make, String model, int horsePower, int passengerCount) {
            super(make, model, horsePower);
            this.passengerCount = passengerCount;
        }
        public int getPassengerCount() { return passengerCount; }
    }

    private static non-sealed class Truck extends Vehicle {
        private final int payloadPounds;
        public Truck(String make, String model, int horsePower, int payloadPounds) {
            super(make, model, horsePower);
            this.payloadPounds = payloadPounds;
        }
        public int getPayloadPounds() { return payloadPounds; }
    }
}

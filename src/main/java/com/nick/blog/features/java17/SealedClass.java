package com.nick.blog.features.java17;

public class SealedClass {
    public static void main(String... args) {
    }

    private sealed interface Engine permits EngineBrand, Vehicle {
        int getHorsePower();
    }

    private sealed class Vehicle implements Engine permits Car, Suv, Truck, Tractor {
        private final String make, model;
        private final int horsePower, price;
        public Vehicle(String make, String model, int horsePower, int price) {
            this.make = make;
            this.model = model;
            this.price = price;
            this.horsePower = horsePower;
        }
        public String getMake() { return make; }
        public String getModel() { return model; }
        public int getHorsePower() { return horsePower; }
        public int getPrice() { return price; }
    }

    private final class Car extends Vehicle {
        private final int passangersCount;
        public Car(String make, String model, int horsePower, int price, int passangersCount) {
            super(make, model, horsePower, price);
            this.passangersCount = passangersCount;
        }
        public int getPassangersCount() { return passangersCount; }
    }

    private final class Suv extends Vehicle {
        private final int passangersCount, payloadPounds;
        public Suv(String make, String model, int horsePower, int price, int passangersCount, int payloadPounds) {
            super(make, model, horsePower, price);
            this.payloadPounds = payloadPounds;
            this.passangersCount = passangersCount;
        }
        public int getPayloadPounds() { return payloadPounds; }
        public int getPassangersCount() { return passangersCount; }
    }

    private final class Truck extends Vehicle {
        private final int payloadPounds;
        public Truck(String make, String model, int horsePower, int price, int payloadPounds) {
            super(make, model, horsePower, price);
            this.payloadPounds = payloadPounds;
        }
        public int getPayloadPounds() { return payloadPounds; }
    }

    private final class Tractor extends Vehicle {
        private final int pullPower;
        public Tractor (String make, String model, int horsePower, int price, int pullPower) {
            super(make, model, horsePower, price);
            this.pullPower = pullPower;
        }
        public int getPullPower() { return pullPower; }
    }

    private non-sealed interface EngineBrand extends Engine {
        String getBrand();
    }


}

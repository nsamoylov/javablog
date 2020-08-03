package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S25_custom_collector {
    public static void main(String... args) {
        System.out.print("\n1.max: ");
        BiConsumer<Box, Box> accumulatorMax = (b1, b2) -> {
            if(b1.getWeight() < b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        BiConsumer<Box, Box> combinerMax = (b1, b2) -> {
            System.out.print("Combiner is called!");
            if(b1.getWeight() < b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        Box theHeaviest = Stream.of(new Box(5, "red"),
                                    new Box(8, "green"),
                                    new Box(3, "blue"))
                .collect(Box::new, accumulatorMax, combinerMax);
        System.out.print(theHeaviest);               //prints: Box{weight=8, color='green'}

        System.out.print("\n2.max: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .parallel()
                .collect(Box::new, accumulatorMax, combinerMax); //prints: Combiner is called!Combiner is called!
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n3.max: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Collectors.maxBy(Comparator.comparing(Box::getWeight)))
                .orElse(null);
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n1.min: ");
        BiConsumer<Box, Box> accumulatorMin = (b1, b2) -> {
            if(b1.getWeight() > b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        BiConsumer<Box, Box> combinerMin = (b1, b2) -> {
            System.out.print("Combiner is called!");
            if(b1.getWeight() > b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        Box theLightest = Stream.of(new Box(5, "red"),
                                    new Box(8, "green"),
                                    new Box(3, "blue"))
                .collect(Box::new, accumulatorMin, combinerMin);
        System.out.print(theLightest);               //prints: Box{weight=0, color='null'}

        System.out.print("\n2.min: ");
        theLightest = Stream.of(new Box(5, "red"),
                new Box(8, "green"),
                new Box(3, "blue"))
                .collect(() -> new Box(10, "whatever"), accumulatorMin, combinerMin);
        System.out.print(theLightest);               //prints: Box{weight=3, color='blue'}

        System.out.print("\n3.min: ");
        BiConsumer<Box, Box> accumulatorMin2 = (b1, b2) -> {
            if(b1.getWeight() == 0 || b1.getWeight() > b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        BiConsumer<Box, Box> combinerMin2 = (b1, b2) -> {
            System.out.print("Combiner is called!");
            if(b1.getWeight() == 0 || b1.getWeight() > b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        theLightest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Box::new, accumulatorMin2, combinerMin2);
        System.out.print(theLightest);                  //prints: Box{weight=3, color='blue'}

        System.out.print("\n4.min: ");
        theLightest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Collectors.minBy(Comparator.comparing(Box::getWeight))) //but cannot be used for parallel streams
                .orElse(null);
        System.out.print(theLightest);                     //prints: Box{weight=3, color='blue'}
    }

    private static class Box {
        private int weight;
        private String color;

        public Box(){}
        public Box(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() { return weight; }

        public void setWeight(int weight) { this.weight = weight; }

        public String getColor() { return color; }

        public void setColor(String color) { this.color = color; }

        @Override
        public String toString() {
            return "Box{weight=" + weight +
                    ", color='" + color + "'}";
        }
    }
}

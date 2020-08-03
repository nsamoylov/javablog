package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S26_collect_maxBy_minBy {
    public static void main(String... args) {
        System.out.print("\n1.maxBy: ");
        Box theHeaviest = Stream.of(new Box(5, "red"),
                                    new Box(8, "green"),
                                    new Box(3, "blue"))
                .collect(Collectors.maxBy(Comparator.comparing(Box::getWeight)))
                .orElse(null);
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n2.maxBy: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Collectors.maxBy(Comparator.comparingInt(Box::getWeight))) //without boxing/unboxing
                .orElse(null);
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("1.minBy: ");
        Box theLightest = Stream.of(new Box(5, "red"),
                                    new Box(8, "green"),
                                    new Box(3, "blue"))
                .collect(Collectors.minBy(Comparator.comparing(Box::getWeight)))  //but cannot be used for parallel streams
                .orElse(null);
        System.out.print(theLightest);                     //prints: Box{weight=3, color='blue'}

        System.out.print("\n2.minBy: ");
        theLightest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Collectors.minBy(Comparator.comparingInt(Box::getWeight))) //without boxing/unboxing
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

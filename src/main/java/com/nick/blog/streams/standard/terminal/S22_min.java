package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.stream.Stream;

public class S22_min {
    public static void main(String... args) {
        System.out.print("1: ");
        String min1 = Stream.of("a", "b", "c", "c", "a")
                .min(Comparator.naturalOrder())
                .get();
        System.out.print(min1);                //prints: a

        System.out.print("\n2: ");
        int min2 = Stream.of(22, 56, 3, -100)
                .min(Comparator.naturalOrder())
                .get();
        System.out.print(min2);                //prints: -100

        System.out.print("\n3: ");
        int min3 = Stream.of(22, 56, 3, -100)
                .min(Comparator.reverseOrder())
                .get();
        System.out.print(min3);                //prints: 56

        System.out.print("\n4: ");
        Box min4 = Stream.of(new Box(5, "red"), new Box(8, "green"), new Box(3, "blue"))
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get();
        System.out.print(min4);                //prints: Box{weight=5, color='red'}

        System.out.print("\n5: ");
        Box min5 = Stream.of(new Box(5, "red"), new Box(8, "green"), new Box(3, "blue"))
                .min(Comparator.comparingInt(b -> b.weight))
                .get();
        System.out.print(min5);                //prints: Box{weight=3, color='blue'}
    }

    private static class Box implements Comparable<Box>{
        int weight;
        String color;

        public Box(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        @Override
        public int compareTo(Box otherBox) {
            return this.color.compareTo(otherBox.color);
        }

        @Override
        public String toString() {
            return "Box{weight=" + weight +
                    ", color='" + color + "'}";
        }
    }
}

package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.stream.Stream;

public class S22_min {
    public static void main(String... args) {
        System.out.print("1: ");
        String max1 = Stream.of("a", "b", "c", "c", "a")
                .min(Comparator.naturalOrder())
                .get();
        System.out.print(max1);                //prints: a

        System.out.print("\n2: ");
        int max2 = Stream.of(22, 56, 3, -100)
                .min(Comparator.naturalOrder())
                .get();
        System.out.print(max2);                //prints: -100

        System.out.print("\n3: ");
        int max3 = Stream.of(22, 56, 3, -100)
                .min(Comparator.reverseOrder())
                .get();
        System.out.print(max3);                //prints: 56

        System.out.print("\n4: ");
        Box max4 = Stream.of(new Box(5, "red"), new Box(8, "green"), new Box(3, "blue"))
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get();
        System.out.print(max4);                //prints: Box{weight=5, color='red'}

        System.out.print("\n5: ");
        Box max5 = Stream.of(new Box(5, "red"), new Box(8, "green"), new Box(3, "blue"))
                .min(Comparator.comparingInt(b -> b.weight))
                .get();
        System.out.print(max5);                //prints: Box{weight=3, color='blue'}
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

package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.stream.Stream;

public class S22_max {
    public static void main(String... args){
        System.out.print("1: ");
        String max1 = Stream.of("a", "b", "c", "c", "a")
                .max(Comparator.naturalOrder())
                .get();
        System.out.print(max1);                //prints: c

        System.out.print("\n1: ");
        max1 = Stream.of("a", "b", "c", "c", "a")
                .parallel()
                .max(Comparator.naturalOrder())
                .get();
        System.out.print(max1);                //prints: c

        System.out.print("\n2: ");
        int max2 = Stream.of(22, 56, 3, -100)
                .max(Comparator.naturalOrder())
                .get();
        System.out.print(max2);                //prints: 56

        System.out.print("\n2: ");
        max2 = Stream.of(22, 56, 3, -100)
                .parallel()
                .max(Comparator.naturalOrder())
                .get();
        System.out.print(max2);                //prints: 56

        System.out.print("\n3: ");
        int max3 = Stream.of(22, 56, 3, -100)
                .max(Comparator.reverseOrder())
                .get();
        System.out.print(max3);                //prints: -100

        System.out.print("\n3: ");
        max3 = Stream.of(22, 56, 3, -100)
                .parallel()
                .max(Comparator.reverseOrder())
                .get();
        System.out.print(max3);                //prints: -100

        System.out.print("\n4: ");
        Box max4 = Stream.of(new Box(5, "red"),
                             new Box(8, "green"),
                             new Box(3, "blue"))
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .get();
        System.out.print(max4);                //prints: Box{weight=3, color='blue'}

        System.out.print("\n4: ");
        max4 = Stream.of(new Box(5, "red"),
                         new Box(8, "green"),
                         new Box(3, "blue"))
                .parallel()
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .get();
        System.out.print(max4);                //prints: Box{weight=3, color='blue'}

        System.out.print("\n5: ");
        Box max5 = Stream.of(new Box(5, "red"),
                             new Box(8, "green"),
                             new Box(3, "blue"))
                .max(Comparator.comparing(Box::getWeight))
                .get();
        System.out.print(max5);                //prints: Box{weight=8, color='green'}

        System.out.print("\n5: ");
        max5 = Stream.of(new Box(5, "red"),
                         new Box(8, "green"),
                         new Box(3, "blue"))
                .parallel()
                .max(Comparator.comparing(Box::getWeight))
                .get();
        System.out.print(max5);                //prints: Box{weight=8, color='green'}

        System.out.print("\n6: ");
        Box min6 = Stream.of(new Box(5, "red"),
                             new Box(8, "green"),
                             new Box(3, "blue"))
                .max(Comparator.comparing(Box::getWeight, Comparator.reverseOrder())) //see S22_min demo class for better solution
                .get();
        System.out.print(min6);                //prints: Box{weight=3, color='blue'}

        System.out.print("\n6: ");
        min6 = Stream.of(new Box(5, "red"),
                         new Box(8, "green"),
                         new Box(3, "blue"))
                .parallel()
                .max(Comparator.comparing(Box::getWeight, Comparator.reverseOrder())) //see S22_min demo class for better solution
                .get();
        System.out.print(min6);                //prints: Box{weight=3, color='blue'}

        System.out.print("\n7: ");
        Box max6 = Stream.of(new Box(5, "red"),
                             new Box(8, "green"),
                             new Box(3, "blue"))
                .max(Comparator.comparingInt(Box::getWeight))   //without boxing/unboxing
                .get();
        System.out.print(max6);                //prints: Box{weight=8, color='green'}

        System.out.print("\n7: ");
        max6 = Stream.of(new Box(5, "red"),
                         new Box(8, "green"),
                         new Box(3, "blue"))
                .parallel()
                .max(Comparator.comparingInt(Box::getWeight))   //without boxing/unboxing
                .get();
        System.out.print(max6);                //prints: Box{weight=8, color='green'}
    }

    private static class Box implements Comparable<Box>{
        int weight;
        String color;

        public Box(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() { return weight; }

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

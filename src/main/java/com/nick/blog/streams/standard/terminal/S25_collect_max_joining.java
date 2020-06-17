package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S25_collect_max_joining {
    public static void main(String... args) {
        System.out.print("1.max: ");
        BiConsumer<Box, Box> accumulator = (b1, b2) -> {
            if(b1.getWeight() < b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        BiConsumer<Box, Box> combiner = (b1, b2) -> {
            System.out.print("Combiner is called!");
            if(b1.getWeight() < b2.getWeight()){
                b1.setWeight(b2.getWeight());
                b1.setColor(b2.getColor());
            }
        };
        Box theHeaviest = Stream.of(new Box(5, "red"),
                                    new Box(8, "green"),
                                    new Box(3, "blue"))
                .collect(Box::new, accumulator, combiner);
        System.out.print(theHeaviest);               //prints: Box{weight=8, color='green'}

        System.out.print("\n2.max: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .parallel()
                .collect(Box::new, accumulator, combiner); //prints: Combiner is called!Combiner is called!
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n3.max: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Collectors.maxBy(Comparator.comparing(Box::getWeight)))
                .orElse(null);
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n4.max: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .collect(Collectors.maxBy(Comparator.comparingInt(Box::getWeight))) //without boxing/unboxing
                .orElse(null);
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n5.max: ");
        theHeaviest = Stream.of(new Box(5, "red"),
                                new Box(8, "green"),
                                new Box(3, "blue"))
                .max(Comparator.comparing(Box::getWeight))
                .orElse(null);
        System.out.print(theHeaviest);                     //prints: Box{weight=8, color='green'}

        System.out.print("\n1.join: ");
        StringJoiner joiner = new StringJoiner(", ").add("cat").add("fish").add("dog");
        System.out.print(joiner);       //prints: cat, fish, dog

        System.out.print("\n2.join: ");
        String string1 = String.join(", ", "cat", "fish", "dog");
        System.out.print(string1);      //prints: cat, fish, dog

        System.out.print("\n3.join: ");
        Iterable<String> list = List.of("cat", "fish", "dog");  //any iterable
        String string2 = String.join(", ", list);
        System.out.print(string2);      //prints: cat, fish, dog

        System.out.print("\n4.join: ");
        String str1 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.joining(", "));
        System.out.print(str1);        //prints: cat, fish, dog

        System.out.print("\n5.join: ");
        String str2 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.joining());
        System.out.print(str2);        //prints: catfishdog

        System.out.print("\n6.join: ");
        String str3 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.joining(", ", "Animals: ", ", and others."));
        System.out.print(str3);        //prints: Animals: cat, fish, dog, and others.
    }

    private static class Box {
        int weight;
        String color;

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

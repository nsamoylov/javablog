package com.nick.blog.streams.standard;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class S16_IntermediateFilterSkipSort {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("2", "4", "3", "4", "2")
                .distinct()
                .forEach(System.out::print);  //prints: 243

        System.out.print("\n2: ");
        Stream.of("2", "4", "3", "4", "2")
                .filter(s -> Objects.equals(s, "2"))
                .forEach(System.out::print);   //prints: 22

        System.out.print("\n3: ");
        Stream.of("2", "4", "3", "4", "2")
                .dropWhile(s -> Integer.valueOf(s) < 3)
                .forEach(System.out::print);   //prints: 4342

        System.out.print("\n4: ");
        Stream.of("2", "4", "3", "4", "2")
                .takeWhile(s -> Integer.valueOf(s) < 3)
                .forEach(System.out::print);   //prints: 2

        System.out.print("\n5: ");
        Stream.of("2", "4", "3", "4", "2")
                .skip(3)
                .forEach(System.out::print);  //prints: 42

        System.out.print("\n6: ");
        Stream.of("2", "4", "3", "4", "2")
                .limit(3)
                .forEach(System.out::print);  //prints: 243

        System.out.print("\n7: ");
        Stream.of("2", "4", "3", "4", "2")
                .sorted().forEach(System.out::print);  //prints: 22344

        System.out.print("\n8: ");
        Stream.of("2", "4", "3", "4", "2")
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);           //prints: 44322
    }
}

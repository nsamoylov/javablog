package com.nick.blog.streams.standard.intermediate;

import java.util.Comparator;
import java.util.stream.Stream;

public class S16_sort {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("2", "4", "3", "4", "2")
                .sorted()
                .forEach(System.out::print);  //prints: 22344

        System.out.print("\n2: ");
        Stream.of("2", "4", "3", "4", "2")
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s)))
                .forEach(System.out::print);  //prints: 22344

        System.out.print("\n3: ");
        Stream.of("2", "4", "3", "4", "2")
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);           //prints: 44322
    }
}

package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S17_mapToObj {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("two", "four", "three")
                .mapToInt(s -> s.length())
                .mapToObj(i -> i + " ")
                .forEach(System.out::print);  //prints: 3 4 5

        System.out.print("\n2: ");
        Stream.of("two", "four", "three")
                .mapToLong(s -> s.length() * 2)
                .mapToObj(l -> l + " ")
                .forEach(System.out::print);  //prints: 6 8 10

        System.out.print("\n3: ");
        Stream.of("two", "four", "three")
                .mapToDouble(s -> s.length() / 2.0)
                .mapToObj(d -> d + " ")
                .forEach(System.out::print);  //prints: 1.5 2.0 2.5
    }
}

package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S16_skip {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("2", "4", "3", "4", "2")
                .dropWhile(s -> Integer.valueOf(s) < 3)
                .forEach(System.out::print);   //prints: 4342

        System.out.print("\n2: ");
        Stream.of("2", "4", "3", "4", "2")
                .takeWhile(s -> Integer.valueOf(s) < 3)
                .forEach(System.out::print);   //prints: 2

        System.out.print("\n3: ");
        Stream.of("2", "4", "3", "4", "2")
                .skip(3)
                .forEach(System.out::print);  //prints: 42

        System.out.print("\n4: ");
        Stream.of("2", "4", "3", "4", "2")
                .limit(3)
                .forEach(System.out::print);  //prints: 243
    }
}

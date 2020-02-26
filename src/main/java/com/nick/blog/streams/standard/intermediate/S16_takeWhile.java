package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S16_takeWhile {
    public static void main(String... args){

        Stream.of("2", "4", "3", "4", "2")
                .takeWhile(s -> Integer.valueOf(s) < 3)
                .forEach(System.out::print);   //prints: 2
    }
}

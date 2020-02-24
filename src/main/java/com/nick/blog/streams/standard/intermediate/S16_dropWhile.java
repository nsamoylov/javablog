package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S16_dropWhile {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("2", "4", "3", "4", "2")
                .dropWhile(s -> Integer.valueOf(s) < 3)
                .forEach(System.out::print);   //prints: 4342
    }
}

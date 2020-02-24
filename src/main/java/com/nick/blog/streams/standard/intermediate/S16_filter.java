package com.nick.blog.streams.standard.intermediate;

import java.util.Objects;
import java.util.stream.Stream;

public class S16_filter {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("2", "4", "3", "4", "2")
                .filter(s -> Objects.equals(s, "2"))
                .forEach(System.out::print);   //prints: 22
    }
}

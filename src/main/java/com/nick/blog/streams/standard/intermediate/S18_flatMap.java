package com.nick.blog.streams.standard.intermediate;

import java.util.Arrays;
import java.util.stream.Stream;

public class S18_flatMap {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("one", "two", "three")
                .flatMap(s -> Arrays.stream(s.split("")))
                .map(s -> s + " ")
                .forEach(System.out::print);  //prints: o n e t w o t h r e e
    }
}

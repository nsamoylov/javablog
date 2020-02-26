package com.nick.blog.streams.standard.intermediate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class S18_flatMapToInt {
    public static void main(String... args){

        Stream.of("one", "two", "three")
                .flatMapToInt(s -> IntStream.range(0, s.length()))
                .forEach(System.out::print);  //prints: 01201201234
    }
}

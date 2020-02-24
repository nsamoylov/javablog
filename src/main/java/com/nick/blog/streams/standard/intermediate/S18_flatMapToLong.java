package com.nick.blog.streams.standard.intermediate;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class S18_flatMapToLong {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("one", "two", "three")
                .flatMapToLong(s -> LongStream.range(0, s.length()))
                .forEach(System.out::print);  //prints: 01201201234
    }
}

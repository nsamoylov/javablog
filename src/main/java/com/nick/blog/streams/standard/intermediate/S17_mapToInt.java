package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S17_mapToInt {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("two", "four", "three")
                .mapToInt(s -> s.length())
                .forEach(System.out::println);  //prints: 3
                                                //        4
                                                //        5
    }
}

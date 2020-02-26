package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S17_mapToLong {
    public static void main(String... args){

        Stream.of("two", "four", "three")
                .mapToLong(s -> s.length() * 2)
                .forEach(System.out::println);  //prints: 6
                                                //        8
                                                //        10
    }
}

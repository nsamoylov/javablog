package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S17_mapToDouble {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("two", "four", "three")
                .mapToDouble(s -> s.length() / 2.0)
                .forEach(System.out::println);  //prints: 1.5
                                                //        2.0
                                                //        2.5

    }
}

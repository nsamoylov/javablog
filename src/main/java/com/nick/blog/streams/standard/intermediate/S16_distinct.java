package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S16_distinct {
    public static void main(String... args) {

        Stream.of("2", "4", "3", "4", "2")
                .distinct()
                .forEach(System.out::print);  //prints: 243
    }
}

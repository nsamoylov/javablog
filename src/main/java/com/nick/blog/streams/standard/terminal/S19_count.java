package com.nick.blog.streams.standard.terminal;

import java.util.stream.Stream;

public class S19_count {
    public static void main(String... args){
        System.out.print("1: ");
        long count = Stream.of("one","two","three","four","five")
                .count();
        System.out.print(count);           //prints: 5
    }
}

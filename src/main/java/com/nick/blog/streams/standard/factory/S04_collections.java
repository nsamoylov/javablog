package com.nick.blog.streams.standard.factory;

import java.util.Arrays;
import java.util.List;

public class S04_collections {
    public static void main(String... args) {
        System.out.print("1: ");
        List.of("one","two","three","four","five")
                .stream()
                .map(s -> s.length())
                .filter(i -> i == 3)
                .forEach(System.out::print); //prints: 33
    }
}

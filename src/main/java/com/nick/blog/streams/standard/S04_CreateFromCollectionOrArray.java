package com.nick.blog.streams.standard;

import java.util.Arrays;
import java.util.List;

public class S04_CreateFromCollectionOrArray {
    public static void main(String... args) {
        System.out.print("1: ");
        List.of("one","two","three","four","five")
                .stream()
                .map(s -> s.length())
                .filter(i -> i == 3)
                .forEach(System.out::print); //prints: 33

        System.out.print("\n2: ");
        String[] arr = {"one","two","three","four","five"};
        Arrays.stream(arr)
                .map(s -> s.length())
                .filter(i -> i == 3)
                .forEach(System.out::print); //prints: 33

        System.out.print("\n3: ");
        Arrays.stream(arr, 1, 4)
                .map(s -> s.length())
                .filter(i -> i == 3)
                .forEach(System.out::print); //prints: 3
    }
}

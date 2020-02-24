package com.nick.blog.streams.standard.factory;

import java.util.Arrays;

public class S04_Arrays {
    public static void main(String... args) {
        System.out.print("1: ");
        String[] arr = {"one","two","three","four","five"};
        Arrays.stream(arr)
                .map(s -> s.length())
                .filter(i -> i == 3)
                .forEach(System.out::print); //prints: 33

        System.out.print("\n2: ");
        Arrays.stream(arr, 1, 4)
                .map(s -> s.length())
                .filter(i -> i == 3)
                .forEach(System.out::print); //prints: 3
    }

}

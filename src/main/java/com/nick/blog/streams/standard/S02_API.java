package com.nick.blog.streams.standard;

import java.util.List;

public class S02_API {
    public static void main(String... args){
        System.out.print("1: ");
        List.of(1, 2, 3)
                .stream()
                .filter(e -> e < 3)
                .forEach(System.out::print); //prints: 12

        System.out.print("\n2: ");
        List.of(1, 2, 3)
                .stream()
                .mapToInt(i -> i)    // creates IntStream
                .filter(e -> e < 3)
                .forEach(System.out::print); //prints: 12

        System.out.print("\n3: ");
        int sum = List.of(1, 2, 3)
                .stream()
                .mapToInt(i -> i)   // creates IntStream
                .filter(e -> e < 3)
                .sum();
        System.out.println(sum);    //prints: 3
    }
}

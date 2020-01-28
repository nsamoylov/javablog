package com.nick.blog.streams.standard;

import java.util.List;

public class S14_FactoryMethodsAndOperations {
    public static void main(String... args) {
        System.out.println("1: ");
        List.of("1","2","3").stream()
                .map(s -> s + "a")
                .peek(System.out::println)
                .map(s -> s + "b")
                .forEach(System.out::println);

        System.out.print("\n2: ");
        long c = List.of("a","b","c").stream().count();
        System.out.print(c);                        //prints: 3

        System.out.print("\n3: ");
        List.of("1","2","3","4")
                .parallelStream()
                .forEach(System.out::print);        //prints: 3421

        System.out.print("\n4: ");
        List.of("1","2","3","4")
                .parallelStream()
                .forEachOrdered(System.out::print); //prints: 1234
    }
}

package com.nick.blog.streams.standard;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class S09_CreateUsingRange {
    public static void main(String... args) {
        System.out.print("1: ");
        IntStream intStream1 = IntStream.range(3, 7);
        intStream1.forEach(System.out::print);  //prints: 3456

        System.out.print("\n2: ");
        IntStream intStream2 = IntStream.rangeClosed(3, 7);
        intStream2.forEach(System.out::print);  //prints: 34567

        System.out.print("\n3: ");
        LongStream longStream1 = LongStream.range(3, 7);
        longStream1.forEach(System.out::print);  //prints: 3456

        System.out.print("\n4: ");
        LongStream longStream2 = LongStream.rangeClosed(3, 7);
        longStream2.forEach(System.out::print);  //prints: 34567
    }
}

package com.nick.blog.streams.standard.factory;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class S09_range {
    public static void main(String... args) {
        System.out.print("1: ");
        IntStream intStream1 = IntStream.range(3, 7);
        intStream1.forEach(System.out::print);  //prints: 3456

        System.out.print("\n2: ");
        LongStream longStream1 = LongStream.range(3, 7);
        longStream1.forEach(System.out::print);  //prints: 3456
    }
}

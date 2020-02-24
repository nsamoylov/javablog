package com.nick.blog.streams.standard.factory;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class S09_rangeClosed {
    public static void main(String... args) {
        System.out.print("1: ");
        IntStream intStream2 = IntStream.rangeClosed(3, 7);
        intStream2.forEach(System.out::print);  //prints: 34567

        System.out.print("\n2: ");
        LongStream longStream2 = LongStream.rangeClosed(3, 7);
        longStream2.forEach(System.out::print);  //prints: 34567
    }
}

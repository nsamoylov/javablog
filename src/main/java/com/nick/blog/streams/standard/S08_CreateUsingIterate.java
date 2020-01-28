package com.nick.blog.streams.standard;

import java.util.stream.Stream;

public class S08_CreateUsingIterate {
    public static void main(String... args) {
        System.out.print("1: ");
        Stream<Integer> stream1 = Stream.iterate(3, i -> i + 2);
        stream1.limit(5).forEach(System.out::print);  //prints: 357911

        System.out.print("\n2: ");
        Stream<Integer> stream2 = Stream.iterate(3, i -> i < 12, i -> i + 2);
        stream2.forEach(System.out::print);            //prints: 357911

    }
}

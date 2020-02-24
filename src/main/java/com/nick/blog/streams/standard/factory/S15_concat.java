package com.nick.blog.streams.standard.factory;

import java.util.List;
import java.util.stream.Stream;

public class S15_concat {
    public static void main(String... args) {
        System.out.print("1: ");
        Stream<Integer> stream1 = List.of(1, 2).stream();
        Stream<Integer> stream2 = List.of(2, 3).stream();
        Stream.concat(stream1, stream2)
                .forEach(System.out::print);    //prints: 1223
    }

}

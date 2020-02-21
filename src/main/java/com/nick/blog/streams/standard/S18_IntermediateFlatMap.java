package com.nick.blog.streams.standard;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class S18_IntermediateFlatMap {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("one", "two", "three")
                .flatMap(s -> Arrays.stream(s.split("")))
                .map(s -> s + " ")
                .forEach(System.out::print);  //prints: o n e t w o t h r e e

        System.out.print("\n2: ");
        Stream.of("one", "two", "three")
                .flatMapToInt(s -> IntStream.range(0, s.length()))
                .forEach(System.out::print);  //prints: 01201201234

        System.out.print("\n3: ");
        Stream.of("one", "two", "three")
                .flatMapToLong(s -> LongStream.range(0, s.length()))
                .forEach(System.out::print);  //prints: 01201201234

        System.out.print("\n4: ");
        Stream.of("one", "two", "three")
                .flatMapToDouble(s -> {
                    double[] arr = new double[s.length()];
                    for(int i = 0; i < s.length(); i++ ){
                        arr[i] = Math.round(i * 0.1 * 10) / 10.;
                    }
                    return DoubleStream.of(arr);
                })
                .mapToObj(d -> d + " ")
                .forEach(System.out::print);  //prints: 0.0 0.1 0.2 0.0 0.1 0.2 0.0 0.1 0.2 0.3 0.4
    }

}

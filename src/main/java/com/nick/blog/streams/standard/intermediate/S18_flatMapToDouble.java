package com.nick.blog.streams.standard.intermediate;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class S18_flatMapToDouble {
    public static void main(String... args){
        System.out.print("1: ");
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

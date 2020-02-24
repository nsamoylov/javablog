package com.nick.blog.streams.standard.factory;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class S05_of {
    public static void main(String... args) {
        System.out.print("1: ");
        Stream.of().forEach(System.out::print);         //prints:

        System.out.print("\n2: ");
        Stream.of(1).forEach(System.out::print);        //prints: 1

        System.out.print("\n3: ");
        Stream.of(1,2).forEach(System.out::print);      //prints: 12

        System.out.print("\n4: ");
        Stream.of("1"," ","2").forEach(System.out::print); //prints: 1 2

        System.out.print("\n5: ");
        String[] strings = {"1"," ","2"};
        Stream.of(strings).forEach(System.out::print);   //prints: 1 2

        System.out.print("\n6: ");
        Stream.of("1"," ",2).forEach(System.out::print);  //prints: 1 2

        System.out.print("\n7: ");
        Stream<Integer> stream1 = Stream.of(1, 2);
        Stream<Integer> stream2 = Stream.of(2, 3);
        Stream<Integer> stream3 = Stream.of(3, 4);
        Stream<Integer> stream4 = Stream.of(4, 5);
        Stream.of(stream1, stream2, stream3, stream4)
                .forEach(System.out::print); //prints: java.util.stream.ReferencePipeline$Head@58ceff1j

        System.out.print("\n8: ");
        Stream.of(stream1, stream2, stream3, stream4)
                .flatMap(e -> e)
                .forEach(System.out::print);    //prints: 12233445

        System.out.print("\n9: ");
        int sum = IntStream.of(1,2,3).sum();
        System.out.print(sum);             //prints: 6

        System.out.print("\n10: ");
        long sumLong = LongStream.of(1,2,3).sum();
        System.out.print(sumLong);         //prints: 6

        System.out.print("\n11: ");
        double avg = DoubleStream.of(1,2,3).average().getAsDouble();
        System.out.print(avg);             //prints: 2.0
    }
}

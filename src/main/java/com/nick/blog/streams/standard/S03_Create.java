package com.nick.blog.streams.standard;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class S03_Create {
    public static void main(String... args){
        System.out.print("1: ");
        Stream<String> s1 = List.of("one","two","three").stream();
        s1.forEach(System.out::print);   //prints: onetwothree

        System.out.print("\n2: ");
        String[] arr = {"one","two","three"};
        Stream<String> s2 = Arrays.stream(arr);
        s2.forEach(System.out::print);   //prints: onetwothree

        System.out.print("\n3: ");
        String[] strings = {"1"," ","2"};
        Stream<String> s3 = Stream.of(strings);
        s3.forEach(System.out::print);   //prints: 1 2

        System.out.print("\n4: ");
        Stream.generate(new Random()::nextInt)
                .limit(2)
                .map(i -> i.toString() + " ")
                .forEach(System.out::print);  //prints: -1843012941 803902133 (every run different)

        System.out.print("\n5: ");
        Stream<Integer> stream =
                Stream.iterate(3, i -> i < 12, i -> i + 2);
        stream.forEach(System.out::print);    //prints: 357911

        System.out.print("\n6: ");
        IntStream intStream1 = IntStream.range(3, 7);
        intStream1.forEach(System.out::print);  //prints: 3456

        System.out.print("\n7: ");
        IntStream intStream2 = IntStream.rangeClosed(3, 7);
        intStream2.forEach(System.out::print);  //prints: 34567

        System.out.print("\n8: ");
        new Random().ints()
                .limit(2)
                .forEach(System.out::println);  //prints: 729828546
                                                //-1094812726 (every run different)
    }
}

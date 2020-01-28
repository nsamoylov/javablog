package com.nick.blog.streams.standard;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class S06_CreateUsingBuilder {
    public static void main(String... args) {
        System.out.print("1: ");
        List<String> strList = List.of("cat", "dog", "cow");
        Stream.Builder<String> strBuilder = Stream.builder();
        for(String s: strList){
            if(s.contains("o")){
                strBuilder.accept(s);
            }
        }
        strBuilder.build().forEach(System.out::print);   //prints: dogcow

        System.out.print("\n2: ");
        Stream.<String>builder()
                .add("a").add("b").add("c").add("d")
                .build()
                .forEach(System.out::print);   //prints: abcd

        System.out.print("\n3: ");
        IntStream.Builder intBuilder = IntStream.builder();
        intBuilder.add(1).add(2);
        intBuilder.accept(3);
        intBuilder.build().forEach(System.out::print);     //prints: 123

        System.out.print("\n4: ");
        LongStream.Builder longBuilder = LongStream.builder();
        longBuilder.add(10).add(20);
        longBuilder.accept(30);
        longBuilder.build().forEach(System.out::print); //prints: 102030

        System.out.print("\n5: ");
        DoubleStream.Builder doubleBuilder = DoubleStream.builder();
        doubleBuilder.add(0.1).add(0.2);
        doubleBuilder.accept(0.3);
        String str = doubleBuilder.build()
                                  .mapToObj(String::valueOf)
                                  .collect(Collectors.joining(", "));
        System.out.print(str);                //prints: 0.1, 0.2, 0.3

        System.out.print("\n6: ");
        List<String> sList = List.of("cat", "dog", "cow");
        String s = sList.stream().collect(Collectors.joining(", "));
        System.out.print(s);      //prints: cat, dog, cow
    }
}

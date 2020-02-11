package com.nick.blog.streams.standard;

import java.util.stream.Stream;

public class S17_IntermediateMap {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("two", "four", "three")
                .map(s -> s.toUpperCase() + " ")
                .forEach(System.out::print);  //prints: TWO FOUR THREE

        System.out.print("\n2: ");
        Stream.of("two", "four", "three")
                .mapToInt(s -> s.length())
                .mapToObj(i -> i + " ")
                .forEach(System.out::print);  //prints: 3 4 5

        System.out.print("\n3: ");
        Stream.of("two", "four", "three")
                .mapToLong(s -> s.length() * 2)
                .mapToObj(l -> l + " ")
                .forEach(System.out::print);  //prints: 6 8 10

        System.out.print("\n4: ");
        Stream.of("two", "four", "three")
                .mapToDouble(s -> s.length() / 2.0)
                .mapToObj(d -> d + " ")
                .forEach(System.out::print);  //prints: 1.5 2.0 2.5

        System.out.print("\n5: ");
        Stream.of("two", "four", "three")
                .map(s -> {
                    if(s.contains("o")){
                        return s.replace("o", "@");
                    } else {
                        return "*".repeat(s.length());
                    }
                })
                .map(s -> s + " ")
                .forEach(System.out::print);  //prints: tw@ f@ur *****

        System.out.print("\n6: ");
        Stream.of("two", "four", "three")
                .map(s -> transformString(s))
                .map(s -> s + " ")
                .forEach(System.out::print);  //prints: tw@ f@ur *****
    }

    private static String transformString(String s){
        if(s.contains("o")){
            return s.replace("o", "@");
        } else {
            return "*".repeat(s.length());
        }
    }
}

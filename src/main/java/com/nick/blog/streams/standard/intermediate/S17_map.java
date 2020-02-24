package com.nick.blog.streams.standard.intermediate;

import java.util.stream.Stream;

public class S17_map {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("two", "four", "three")
                .map(s -> s.toUpperCase() + " ")
                .forEach(System.out::print);  //prints: TWO FOUR THREE

        System.out.print("\n2: ");
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

        System.out.print("\n3: ");
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

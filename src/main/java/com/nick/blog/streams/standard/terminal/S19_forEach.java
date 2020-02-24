package com.nick.blog.streams.standard.terminal;

import java.util.stream.Stream;

public class S19_forEach {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("1","2","3","4","5")
                .forEach(System.out::print);      //prints: 12345


        System.out.print("\n2: ");
        Stream.of("1","2","3","4","5")
                .parallel()
                .forEach(System.out::print);      //prints: 34215  //depends on the particular system
    }
}

package com.nick.blog.streams.standard.terminal;

import java.util.stream.Stream;

public class S19_forEachOrdered {
    public static void main(String... args){
        System.out.print("1: ");
        Stream.of("1","2","3","4","5")
                .forEachOrdered(System.out::print);      //prints: 12345

        System.out.print("\n2: ");
        Stream.of("1","2","3","4","5")
                .parallel()
                .forEachOrdered(System.out::print);      //prints: 12345
        // The processing order is defined at the source and does not depend on the executing system
    }
}

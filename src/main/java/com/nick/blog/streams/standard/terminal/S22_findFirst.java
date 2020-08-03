package com.nick.blog.streams.standard.terminal;

import java.util.stream.Stream;

public class S22_findFirst {
    public static void main(String... args){
        System.out.print("\n1: ");
        String res1 = Stream.of("b", "c", "c", "a")
                .findFirst()
                .orElse("x");
        System.out.print(res1);                //prints: b

        System.out.print("\n2: ");
        String res2 = Stream.of("b", "c", "c", "a")
                .parallel()
                .findFirst()
                .orElse("x");
        System.out.print(res2);                //prints: b (may be different from run to run)

        System.out.print("\n3: ");
        String res3 = Stream.of("b", "c", "c", "a")
                .filter(s -> s.equals("z"))
                .findFirst()
                .orElse("x");
        System.out.print(res3);                //prints: x

    }
}

package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x11_Operation_filter {
    public static void main(String... args){
        System.out.print("\n1: ");
        String v1 = Optional.of("1")
                .filter(s -> s.equals("1"))
                .or(() -> Optional.of("42"))
                .get();
        System.out.print(v1);              //prints: 1

        System.out.print("\n2: ");
        String v2 = Optional.of("1")
                .filter(s -> s.equals("2"))
                .or(() -> Optional.of("42"))
                .get();
        System.out.print(v2);             //prints: 42
    }
}

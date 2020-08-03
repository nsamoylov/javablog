package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x06_Operation_orElse {
    public static void main(String... args){
        System.out.print("\n1: ");
        String result1 = Optional.of("1")
                .orElse("42");
        System.out.print(result1);           //prints: 1

        System.out.print("\n2: ");
        String result2 = Optional.of("1")
                .filter(s -> s.equals("2"))
                .orElse("42");
        System.out.print(result2);           //prints: 42
    }
}

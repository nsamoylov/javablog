package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x14_Operation_stream {
    public static void main(String... args){
        System.out.print("1: ");
        Optional.of("abc")
                .stream()
                .forEach(System.out::print);              //prints: abc

        System.out.print("\n2: ");
        Optional.of("abc")
                .filter(s -> s.equals("42"))
                .stream()
                .forEach(System.out::print);              //prints:
    }
}

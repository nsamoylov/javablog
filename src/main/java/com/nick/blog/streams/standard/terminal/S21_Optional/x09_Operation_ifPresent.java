package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;
import java.util.function.Consumer;

public class x09_Operation_ifPresent {
    public static void main(String... args){
        System.out.print("\n1: ");
        Optional.of("1")
                .ifPresent(System.out::print);   //prints: 1

        System.out.print("\n2: ");
        Optional.of("1")
                .filter(s -> s.equals("2"))
                .ifPresent(System.out::print);   //prints nothing

        System.out.print("\n3: ");
        Consumer<String> doSomething = s -> {
            //Code that does something
            System.out.print(s);;
        };

        Optional.of("1")
                .ifPresent(doSomething);         //prints: 1

        System.out.print("\n4: ");
        Optional.of("1")
                .filter(s -> s.equals("2"))
                .ifPresent(doSomething);         //prints nothing
    }
}

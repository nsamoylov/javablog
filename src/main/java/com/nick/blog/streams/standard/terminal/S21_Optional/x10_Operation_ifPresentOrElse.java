package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;
import java.util.function.Consumer;

public class x10_Operation_ifPresentOrElse {
    public static void main(String... args){
        System.out.print("1: ");
        Optional.of("1")
                .ifPresentOrElse(
                        System.out::print,
                        () -> System.out.print("42"));   //prints: 1

        System.out.print("\n2: ");
        Optional.of("1")
                .filter(s -> s.equals("2"))
                .ifPresentOrElse(
                        System.out::print,
                        () -> System.out.print("42"));    //prints: 42

        System.out.print("\n3: ");
        Consumer<String> doSomething = s ->
        {
            //Code that does something
            System.out.print(s);;
        };
        Runnable doSomethingElse = () ->
        {
            //Code that does something else
            System.out.println("42");;
        };

        Optional.of("1")
                .ifPresentOrElse(doSomething, doSomethingElse);  //prints: 1

        System.out.print("\n4: ");
        Optional.of("1")
                .filter(s -> s.equals("2"))
                .ifPresentOrElse(doSomething, doSomethingElse);  //prints: 42

    }
}

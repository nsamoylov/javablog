package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x05_Operation_or {
    public static void main(String... args){
       System.out.print("\n1: ");
       Optional<String> opt1 = Optional.of("1")
                       .or(() -> Optional.of("42"));
        System.out.print("\n  .get(): ");
        System.out.print(opt1.get());           //prints: 1

        System.out.print("\n  .isEmpty(): ");
        System.out.print(opt1.isEmpty());      //prints: false

        System.out.print("\n  .isPresent(): ");
        System.out.print(opt1.isPresent());    //prints: true


        System.out.print("\n\n2: ");
        Optional<String> opt2 = Optional.of("1")
                .filter(s -> s.equals("2"))
                .or(() -> Optional.of("42"));
        System.out.print("\n  .get(): ");
        System.out.print(opt2.get());          //prints: 42

        System.out.print("\n  .isEmpty(): ");
        System.out.print(opt2.isEmpty());      //prints: false

        System.out.print("\n  .isPresent(): ");
        System.out.print(opt2.isPresent());    //prints: true
    }

}

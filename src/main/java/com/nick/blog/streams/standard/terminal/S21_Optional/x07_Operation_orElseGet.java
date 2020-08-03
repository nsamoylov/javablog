package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;
import java.util.function.Supplier;

public class x07_Operation_orElseGet {
    public static void main(String... args) {
        System.out.print("\n1: ");
        String result1 = Optional.of("1")
                .orElseGet(() -> "42");
        System.out.print(result1);           //prints: 1

        System.out.print("\n2: ");
        String result2 = Optional.of("1")
                .filter(s -> s.equals("2"))
                .orElseGet(() -> "42");
        System.out.print(result2);           //prints: 42

        System.out.print("\n3: ");
        Supplier<String> doSomethingElse = () -> {
            //Code that does something else
            return "42";
        };
        String result3 = Optional.of("1")
                .orElseGet(doSomethingElse);
        System.out.print(result3);           //prints: 1

        System.out.print("\n4: ");
        String result4 = Optional.of("1")
                .filter(s -> s.equals("2"))
                .orElseGet(doSomethingElse);
        System.out.print(result4);           //prints: 42
    }
}

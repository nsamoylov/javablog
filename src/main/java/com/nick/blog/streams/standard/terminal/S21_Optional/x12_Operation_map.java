package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.List;
import java.util.Optional;

public class x12_Operation_map {
    public static void main(String... args){
        System.out.print("1: ");
        int v1 = Optional.of("abc")
                .map(s -> s.length())
                .orElse(42);
        System.out.print(v1);              //prints: 3

        System.out.print("\n2: ");
        int v2 = Optional.of(List.of("a","b","c"))
                .map(List::size)
                .orElse(42);
        System.out.print(v2);              //prints: 3

        System.out.print("\n3: ");
        int v3 = Optional.of(Optional.of("abc"))
                .map(o -> Optional.of(o.get().length()).orElse(23))
                .orElse(42);
        System.out.print(v3);              //prints: 3
    }
}

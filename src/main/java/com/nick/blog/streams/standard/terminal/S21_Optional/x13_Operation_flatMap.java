package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x13_Operation_flatMap {
    public static void main(String... args){
        System.out.print("\n1: ");
        int v3 = Optional.of(Optional.of("abc"))
                .flatMap(o -> Optional.of(o.get().length()))
                .orElse(42);
        System.out.print(v3);              //prints: 3
    }
}

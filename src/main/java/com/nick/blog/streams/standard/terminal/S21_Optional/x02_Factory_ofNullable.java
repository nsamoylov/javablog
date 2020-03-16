package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x02_Factory_ofNullable {
    public static void main(String... args){
        Optional<String> opt1 = Optional.ofNullable("1");
        System.out.print("Optional.ofNullable(\"1\"): ");
        System.out.println(opt1.get());       //prints: 1

        Optional<String> opt2 = Optional.ofNullable(null);
        System.out.println("\nOptional.ofNullable(null): ");
        System.out.println(opt2.get());        //throws NoSuchElementException
    }
}

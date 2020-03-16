package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x01_Factory_of {
    public static void main(String... args){
        Optional<String> opt1 = Optional.of("1");
        System.out.print("Optional.of(\"1\"): ");
        System.out.println(opt1.get());            //prints: 1

        Optional<String> opt2 = Optional.of(null); //throws NullPointerException
        System.out.print("\nOptional.of(null): ");
        System.out.println(opt2.get());
   }
}

package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x01_Factory_of {
    public static void main(String... args){
        Optional<String> opt1 = Optional.of("1");
        System.out.print("\nOptional.of(\"1\"): ");
        System.out.println(opt1.get());            //prints: 1

        try{
            Optional<String> opt2 = Optional.of(null);
        } catch(Exception ex){
            System.out.println(ex.getClass().getSimpleName()); //prints: NullPointerException
        }
   }
}

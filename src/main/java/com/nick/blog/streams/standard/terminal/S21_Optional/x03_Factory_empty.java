package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;

public class x03_Factory_empty {
    public static void main(String... args){
        Optional<String> opt1 = Optional.empty();
        System.out.println("\nOptional.empty(): ");
        System.out.println(opt1.get());   //throws NoSuchElementException
    }
}

package com.nick.blog.streams.standard.terminal;

import java.util.List;

public class S20_allMatch {
    public static void main(String... args){

        boolean found = List.of("1", "2", "3", "4", "5")
                .stream()
                .peek(System.out::print)         //prints: 1
                .allMatch(e -> "3".equals(e));
        System.out.println("\n" + found);        //prints: false
    }
}

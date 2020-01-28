package com.nick.blog.streams.standard;

import java.util.stream.Stream;

public class S07_CreateUsingGenerate2 {
    private static int count = 1;

    private static String calculateString(){
        return String.valueOf(count++);
    }

    public static void main(String... args){
        Stream.generate(() -> calculateString())
                .limit(5)
                .forEach(System.out::print);    //prints: 12345
    }
}

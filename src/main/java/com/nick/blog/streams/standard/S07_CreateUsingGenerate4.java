package com.nick.blog.streams.standard;

import java.util.stream.Stream;

public class S07_CreateUsingGenerate4 {
    private int count = 1;

    public String calculateString(){
        return String.valueOf(count++);
    }

    public static void main(String... args){
        new S07_CreateUsingGenerate4().demo();
    }

    public void demo(){
        Stream.generate(this::calculateString)
                .limit(5)
                .forEach(System.out::print);    //prints: 12345

    }
}

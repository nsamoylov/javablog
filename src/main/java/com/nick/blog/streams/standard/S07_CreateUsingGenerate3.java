package com.nick.blog.streams.standard;

import java.util.stream.Stream;

public class S07_CreateUsingGenerate3 {
    private int count = 1;

    public String calcString(){
        return String.valueOf(count++);
    }

    public static void main(String... args){
        Stream.generate(new S07_CreateUsingGenerate3()::calcString)
                .limit(5)
                .forEach(System.out::print);    //prints: 12345
    }
}

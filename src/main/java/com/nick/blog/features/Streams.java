package com.nick.blog.features;

import java.util.List;

public class Streams {
    public static void main(String... args){
        List<String> list = List.of("it"," ","wor","ks");
        list.stream().forEach(System.out::print); //prints: it works

        System.out.println("");

        //List<String>
        list = List.of("it"," ","wor","ks");
        list.stream().map(s -> s.length())
                .filter(i -> i == 2)
                .forEach(System.out::print);   //prints: 22
    }
}

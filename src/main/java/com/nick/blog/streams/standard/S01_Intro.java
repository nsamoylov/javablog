package com.nick.blog.streams.standard;

import java.util.List;

public class S01_Intro {
    public static void main(String... args){
        System.out.print("1: ");
        List<String> list = List.of("it"," ","wor","ks");
        list.stream().forEach(System.out::print); //prints: it works

        System.out.print("\n2: ");
        //List<String>
                list = List.of("it"," ","wor","ks");
        list.stream().map(s -> s.length())
                .filter(i -> i == 2)
                .forEach(System.out::print);   //prints: 22
    }
}

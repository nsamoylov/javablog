package com.nick.blog.streams.standard.factory;

import java.util.regex.Pattern;

public class S13_Pattern {
    public static void main(String... args) {

        Pattern pattern = Pattern.compile("[\\,\\.\\-]");
        pattern.splitAsStream("one-two,three.four")
                .forEach(System.out::println);
    }
}
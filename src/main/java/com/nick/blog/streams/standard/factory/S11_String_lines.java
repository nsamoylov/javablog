package com.nick.blog.streams.standard.factory;

import java.util.stream.Stream;

public class S11_String_lines {
    public static void main(String... args) {

        Stream<String> linesStream = "Once\nupon\ra\r\ntime".lines();
        linesStream.forEach(System.out::println);    }
}

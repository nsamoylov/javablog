package com.nick.blog.features.java16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToList {
    public static void main(String... args) {
        System.out.print("1: ");
        List<String> oldStyle = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> newStyle = Stream.of("a", "b", "c").toList();
        boolean res = Arrays.equals(oldStyle.toArray(), newStyle.toArray());
        System.out.print(res);     //prints: true
    }
}

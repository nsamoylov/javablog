package com.nick.blog.streams.standard.factory;

import java.util.ArrayList;
import java.util.stream.Stream;

public class S15_empty {
    public static void main(String... args) {
        System.out.print("1: ");
        Stream.empty()
                .forEach(System.out::print); //prints nothing

        System.out.print("\n2: ");
        new ArrayList().stream()
                .forEach(System.out::print); //prints nothing
    }

}

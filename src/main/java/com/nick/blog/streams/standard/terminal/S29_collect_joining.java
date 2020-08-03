package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S29_collect_joining {
    public static void main(String... args) {
        System.out.print("\n1.join: ");
        StringJoiner joiner = new StringJoiner(", ").add("cat").add("fish").add("dog");
        System.out.print(joiner);       //prints: cat, fish, dog

        System.out.print("\n2.join: ");
        String string1 = String.join(", ", "cat", "fish", "dog");
        System.out.print(string1);      //prints: cat, fish, dog

        System.out.print("\n3.join: ");
        Iterable<String> list = List.of("cat", "fish", "dog");  //any iterable
        String string2 = String.join(", ", list);
        System.out.print(string2);      //prints: cat, fish, dog

        System.out.print("\n1.joining: ");
        String str1 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.joining(", "));
        System.out.print(str1);        //prints: cat, fish, dog

        System.out.print("\n2.joining: ");
        String str2 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.joining());
        System.out.print(str2);        //prints: catfishdog

        System.out.print("\n7.joining: ");
        String str3 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.joining(", ", "Animals: ", ", and others."));
        System.out.print(str3);        //prints: Animals: cat, fish, dog, and others.
    }
}

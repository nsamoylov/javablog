package com.nick.blog.streams.standard.terminal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S27_collect_list_set {
    public static void main(String... args) {
        System.out.print("1.list: ");
        List<String> list1 = Stream.of("a", "a", "b")
                .collect(Collectors.toList());
        System.out.print(list1);                    //prints: [a, a, b]

        System.out.print("\n2.list: ");
        List<String> list2 = Stream.of("a", "a", "b")
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.print(list2);        //prints: [a, b]

        System.out.print("\n1.set: ");
        Set<String> set1 = Stream.of("a", "a", "b")
                .collect(Collectors.toSet());
        System.out.print(set1);                     //prints: [a, b]

        System.out.print("\n2.set: ");
        Set<String> set2 = Stream.of("a", "a", "b")
                .collect(Collectors.toCollection(HashSet::new));
        System.out.print(set2);        //prints: [a, b]
    }
}

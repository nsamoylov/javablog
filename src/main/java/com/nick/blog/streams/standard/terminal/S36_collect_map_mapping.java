package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S36_collect_map_mapping {
    public static void main(String... args) {
        System.out.print("\n1.mapping(s.charAt(0), toList()): ");
        //List<Character> map1 = Stream.of("cat", "fish", "cat", "dog").map(s -> s.charAt(0)).collect(Collectors.toList());
        List<Character> map1 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.mapping(s -> s.charAt(0), Collectors.toList()));
        System.out.print(map1);        //prints: [c, f, c, d]

        System.out.print("\n2.mapping(s.charAt(0), toSet()) : ");
        Set<Integer> map2 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.mapping(String::length, Collectors.toSet()));
        System.out.print(map2);        //prints: [3, 4]

        System.out.print("\n3.groupingBy(String::length, mapping(s.charAt(0), toList()): ");
        Map<Integer, List<Character>> map3 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.toList())));
        System.out.print(map3);        //prints: {3=[c, c, d], 4=[f]}

        System.out.print("\n4.partitioningBy(s.length() == 3, mapping(s.charAt(0), toList()): ");
        Map<Boolean, List<Character>> map4 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.partitioningBy(s -> s.length() == 3, Collectors.mapping(s -> s.charAt(0), Collectors.toList())));
        System.out.print(map4);        //prints: {false=[f], true=[c, c, d]}
    }
}

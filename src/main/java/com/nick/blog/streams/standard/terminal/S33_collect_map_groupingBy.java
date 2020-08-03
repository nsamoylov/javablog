package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S33_collect_map_groupingBy {
    public static void main(String... args) {
        System.out.print("\n1.groupingBy(Function.identity())              : ");
        Map<String, List<String>> map1 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(Function.identity()));
        System.out.print(map1);        //prints: {fish=[fish], cat=[cat, cat], dog=[dog]}

        System.out.print("\n2.groupingBy(String::length)                   : ");
        Map<Integer, List<String>> map2 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length));
        System.out.print(map2);        //prints: {3=[cat, cat, dog], 4=[fish]}

        System.out.print("\n3.groupingBy(String::length, .toSet())         : ");
        Map<Integer, Set<String>> map3 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.print(map3);        //prints: {3=[cat, dog], 4=[fish]}

        System.out.print("\n4.groupingBy(Function.identity(), .counting()) : ");
        Map<String, Long> map4 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.print(map4);        //prints: {fish=1, cat=2, dog=1}

        System.out.print("\n5.groupingBy(String::length, .groupingBy(Function.identity()))                                      : ");
        Map<Integer, Map<String, List<String>>> map5 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(Function.identity())));
        System.out.print(map5);        //prints: {3={cat=[cat, cat], dog=[dog]}, 4={fish=[fish]}}

        System.out.print("\n6.groupingBy(String::length, .groupingBy(Function.identity(), .counting()))                         : ");
        Map<Integer, Map<String, Long>> map6 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.print(map6);        //prints: {3={cat=2, dog=1}, 4={fish=1}}

        System.out.print("\n7.groupingBy(String::length, ConcurrentHashMap::new, .groupingBy(Function.identity(), .counting())) : ");
        ConcurrentMap<Integer, Map<String, Long>> map7 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, ConcurrentHashMap::new, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.print(map7);        //prints: {3={cat=2, dog=1}, 4={fish=1}}
    }
}

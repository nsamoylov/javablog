package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S34_collect_map_groupingByConcurrent {
    public static void main(String... args) {
        System.out.print("\n1.groupingByConcurrent(Function.identity())              : ");
        ConcurrentMap<String, List<String>> map1 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(Function.identity()));
        System.out.print(map1);        //prints: {fish=[fish], cat=[cat, cat], dog=[dog]}

        System.out.print("\n2.groupingByConcurrent(String::length)                   : ");
        ConcurrentMap<Integer, List<String>> map2 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.print(map2);        //prints: {3=[cat, cat, dog], 4=[fish]}

        System.out.print("\n3.groupingByConcurrent(String::length, .toSet())         : ");
        ConcurrentMap<Integer, Set<String>> map3 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.toSet()));
        System.out.print(map3);        //prints: {3=[cat, dog], 4=[fish]}

        System.out.print("\n4.groupingByConcurrent(Function.identity(), .counting()) : ");
        ConcurrentMap<String, Long> map4 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
        System.out.print(map4);        //prints: {fish=1, cat=2, dog=1}

        System.out.print("\n5.groupingByConcurrent(String::length, .groupingBy(Function.identity()))                                      : ");
        ConcurrentMap<Integer, Map<String, List<String>>> map5 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.groupingBy(Function.identity())));
        System.out.print(map5);        //prints: {3={cat=[cat, cat], dog=[dog]}, 4={fish=[fish]}}

        System.out.print("\n6.groupingByConcurrent(String::length, .groupingBy(Function.identity(), .counting()))                         : ");
        ConcurrentMap<Integer, Map<String, Long>> map6 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.print(map6);        //prints: {3={cat=2, dog=1}, 4={fish=1}}

        System.out.print("\n7.groupingByConcurrent(String::length, ConcurrentHashMap::new, .groupingBy(Function.identity(), .counting())) : ");
        ConcurrentSkipListMap<Integer, Map<String, Long>> map7 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingByConcurrent(String::length, ConcurrentSkipListMap::new, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.print(map7);        //prints: {3={cat=2, dog=1}, 4={fish=1}}
    }
}


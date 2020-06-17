package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S28_collect_map {
    public static void main(String... args) {
        System.out.print("01.map: ");
        Map<String, Integer> map1 = Stream.of("cat", "fish", "hedgehog")
                .collect(Collectors.toMap(s -> s, s -> s.length()));
        System.out.print(map1);        //prints: {hedgehog=8, cat=3, fish=4}

        System.out.print("\n02.map: ");
        Map<String, Integer> map2 = Stream.of("cat", "fish", "hedgehog")
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.print(map2);        //prints: {hedgehog=8, cat=3, fish=4}

        System.out.print("\n03.map: ");
        try {
            Map<String, Integer> map3 = Stream.of("cat", "fish", "cat")
                    .collect(Collectors.toMap(Function.identity(), String::length));
        } catch (Exception ex){
            System.out.print(ex.getMessage()); //prints: Duplicate key cat (attempted merging values 3 and 3)
        }

        System.out.print("\n04.map: ");
        //First key wins
        Map<String, Integer> map4 = Stream.of("cat", "fish", "cat")
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue));
        System.out.print(map4);        //prints: {fish=4, cat=3}

        System.out.print("\n05.map: ");
        //Last key wins
        Map<String, Integer> map5 = Stream.of("cat", "fish", "cat")
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, nextValue) -> nextValue));
        System.out.print(map5);        //prints: {fish=4, cat=3}

        System.out.print("\n06.map: ");
        //TreeMap is sorted according to the natural ordering of its keys by default
        TreeMap<String, Integer> map6 = Stream.of("cat", "fish", "cat")
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, nextValue) -> nextValue, TreeMap::new));
        System.out.print(map6);        //prints: {cat=3, fish=4}

        System.out.print("\n07.map: ");
        Map<String, List<String>> map7 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(Function.identity()));
        System.out.print(map7);        //prints: {fish=[fish], cat=[cat, cat], dog=[dog]}

        System.out.print("\n08.map: ");
        Map<Integer, List<String>> map8 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length));
        System.out.print(map8);        //prints: {3=[cat, cat, dog], 4=[fish]}

        System.out.print("\n09.map: ");
        Map<Integer, Set<String>> map9 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.print(map9);        //prints: {3=[cat, dog], 4=[fish]}

        System.out.print("\n10.map: ");
        Map<String, Long> map10 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.print(map10);        //prints: {fish=1, cat=2, dog=1}

        System.out.print("\n11.map: ");
        Map<Integer, Map<String, List<String>>> map11 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(Function.identity())));
        System.out.print(map11);        //prints: {3={cat=[cat, cat], dog=[dog]}, 4={fish=[fish]}}

        System.out.print("\n12.map: ");
        Map<Integer, Map<String, Long>> map12 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.print(map12);        //prints: {3={cat=2, dog=1}, 4={fish=1}}

        System.out.print("\n13.map: ");
        ConcurrentMap<Integer, Map<String, Long>> map13 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length, ConcurrentHashMap::new, Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.print(map13);        //prints: {3={cat=2, dog=1}, 4={fish=1}}

        //.toUnmodifiableMap() .toUnmodifiableList() .toConcurrentMap()

        //.summarizingDouble/Long/Int() .summingDouble/Long/Int()  minBy() .maxBy() .averagingLong().averagingInt()  .averagingDouble()
        // .mapping() .flatMapping() .filtering()
        //.reducing() .partitioningBy()
        //.collectingAndThen()
        //.teeing()
    }
}

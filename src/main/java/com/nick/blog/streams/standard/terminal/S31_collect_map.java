package com.nick.blog.streams.standard.terminal;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S31_collect_map {
    public static void main(String... args) {
        System.out.print("\n1.toMap(): ");
        Map<String, Integer> map1 = Stream.of("cat", "fish", "hedgehog")
                .collect(Collectors.toMap(s -> s, s -> s.length()));
        System.out.print(map1);        //prints: {hedgehog=8, cat=3, fish=4}

        System.out.print("\n2.toMap(): ");
        Map<String, Integer> map2 = Stream.of("cat", "fish", "hedgehog")
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.print(map2);        //prints: {hedgehog=8, cat=3, fish=4}

        System.out.print("\n3.toMap(duplicate): ");
        try {
            Map<String, Integer> map3 = Stream.of("cat", "fish", "cat")
                    .collect(Collectors.toMap(Function.identity(), String::length));
        } catch (Exception ex){
            System.out.print(ex.getMessage()); //prints: Duplicate key cat (attempted merging values 3 and 3)
        }

        System.out.print("\n4.toMap(keyMapper, valueMapper, mergeFunction(first wins)): ");
        //First key wins
        Map<String, Integer> map4 = Stream.of("cat", "fish", "cat")
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue));
        System.out.print(map4);        //prints: {fish=4, cat=3}

        System.out.print("\n5.toMap(keyMapper, valueMapper, mergeFunction(combines)):   ");
        //Combines the values
        Map<String, Integer> map5 = Stream.of("cat", "fish", "cat")
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue + 100));
        System.out.print(map5);        //prints: {fish=4, cat=103}

        System.out.print("\n6.toMap(keyMapper, valueMapper, mergeFunction(), TreeMap):  ");
        //TreeMap is sorted according to the natural ordering of its keys by default
        TreeMap<String, Integer> map6 = Stream.of("cat", "fish", "cat", "cat")
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue + 100, TreeMap::new));
        System.out.print(map6);        //prints: {cat=203, fish=4}
    }
}

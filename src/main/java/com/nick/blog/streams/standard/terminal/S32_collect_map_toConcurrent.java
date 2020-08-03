package com.nick.blog.streams.standard.terminal;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S32_collect_map_toConcurrent {
    public static void main(String... args) {
        System.out.print("\n1.toConcurrentMap(Function.identity(), String::length) : ");
        ConcurrentMap<String, Integer> map1 = Stream.of("cat", "fish", "dog")
                .parallel()
                .collect(Collectors.toConcurrentMap(Function.identity(), String::length));
        System.out.print(map1);        //prints: {fish=4, cat=3, dog=3}

        System.out.print("\n2.toConcurrentMap(duplicate): ");
        try {
            ConcurrentMap<String, Integer> map2 = Stream.of("cat", "fish", "cat")
                    .parallel()
                    .collect(Collectors.toConcurrentMap(Function.identity(), String::length));
        } catch (Exception ex){
            System.out.print(ex.getMessage()); //prints: Duplicate key cat (attempted merging values 3 and 3)
        }

        System.out.print("\n3.toConcurrentMap(keyMapper, valueMapper, mergeFunction(first wins)): ");
        //First key wins
        ConcurrentMap<String, Integer> map3 = Stream.of("cat", "fish", "cat")
                .parallel()
                .collect(Collectors.toConcurrentMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue));
        System.out.print(map3);        //prints: {fish=4, cat=3}

        System.out.print("\n4.toConcurrentMap(keyMapper, valueMapper, mergeFunction(combines)):   ");
        //Combines the values
        ConcurrentMap<String, Integer> map4 = Stream.of("cat", "fish", "cat")
                .parallel()
                .collect(Collectors.toConcurrentMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue + 100));
        System.out.print(map4);        //prints: {fish=4, cat=103}

        System.out.print("\n5.toConcurrentMap(keyMapper, valueMapper, mergeFunction(), ConcurrentSkipListMap): ");
        //TreeMap is sorted according to the natural ordering of its keys by default
        ConcurrentSkipListMap<String, Integer> map5 = Stream.of("cat", "fish", "cat", "cat")
                .parallel()
                .collect(Collectors.toConcurrentMap(Function.identity(), String::length, (oldValue, nextValue) -> oldValue + 100, ConcurrentSkipListMap::new));
        System.out.print(map5);        //prints: {cat=203, fish=4}
    }
}

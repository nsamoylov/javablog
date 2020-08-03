package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S35_collect_map_partitioningBy {
    public static void main(String... args) {
        System.out.print("\n1.partitioningBy(s.length() == 3)          : ");
        Map<Boolean, List<String>> map1 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.partitioningBy(s -> s.length() == 3));
        System.out.print(map1);        //prints: {false=[fish], true=[cat, cat, dog]}

        System.out.print("\n2.partitioningBy(s.length() == 3, toSet)   : ");
        Map<Boolean, Set<String>> map3 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.partitioningBy(s -> s.length() == 3, Collectors.toSet()));
        System.out.print(map3);        //prints: {false=[fish], true=[cat, dog]}

        System.out.print("\n3.partitioningBy(s.length() == 3, joining) : ");
        Map<Boolean, String> map2 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.partitioningBy(s -> s.length() == 3, Collectors.joining(", ")));
        System.out.print(map2);        //prints: {false=fish, true=cat, cat, dog}
    }
}

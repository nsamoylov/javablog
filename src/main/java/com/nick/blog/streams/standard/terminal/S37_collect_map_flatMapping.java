package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S37_collect_map_flatMapping {
    public static void main(String... args) {
        System.out.print("\n1.flatMapping(s.charAt(0), toList()): ");
        //List<Character> map1 = Stream.of("cat", "fish", "cat", "dog").flatMap(s -> s.chars().mapToObj(c -> (char)c)).collect(Collectors.toList());
        List<Character> map1 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.flatMapping(s -> s.chars()
                                                      .mapToObj(c -> (char)c),
                                                         Collectors.toList()));
        System.out.print(map1);  //prints: [c, a, t, f, i, s, h, c, a, t, d, o, g]

        System.out.print("\n2.flatMapping(s.charAt(0), toSet()) : ");
        List<Character> map2 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.flatMapping(s -> s.chars()
                                                      .mapToObj(c -> (char)c)
                                                      .filter(c -> !c.equals('a')),
                                                              Collectors.toList()));
        System.out.print(map2);  //prints: [c, t, f, i, s, h, c, t, d, o, g]

        System.out.print("\n3.groupingBy(String::length, flatMapping(s.charAt(0), toList())     : ");
        Map<Integer, List<Character>> map3 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.groupingBy(String::length,
                        Collectors.flatMapping(s -> s.chars()
                                                     .mapToObj(c -> (char)c),
                                                       Collectors.toList())));
        System.out.print(map3);  //prints: {3=[c, a, t, c, a, t, d, o, g], 4=[f, i, s, h]}

        System.out.print("\n4.partitioningBy(s.length() == 3, flatMapping(s.charAt(0), toList()): ");
        Map<Boolean, List<Character>> map4 = Stream.of("cat", "fish", "cat", "dog")
                .collect(Collectors.partitioningBy(s -> s.length() == 3,
                        Collectors.flatMapping(s -> s.chars()
                                                     .mapToObj(c -> (char)c)
                                                     .filter(c -> !c.equals('a')),
                                                            Collectors.toList())));
        System.out.print(map4);   //prints: {false=[f, i, s, h], true=[c, t, c, t, d, o, g]}
    }
}

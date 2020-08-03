package com.nick.blog.streams.standard.terminal;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S30_collect_list_set {
    public static void main(String... args) {
        System.out.print("\n1.tolist(): ");
        List<String> list1 = Stream.of("a", "a", "b")
                .collect(Collectors.toList());
        System.out.print(list1);                    //prints: [a, a, b]

        System.out.print("\n2.toCollection(LinkedList): ");
        List<String> list2 = Stream.of("a", "a", "b")
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.print(list2);                    //prints: [a, a, b]

        System.out.print("\n1.toSet(): ");
        Set<String> set1 = Stream.of("a", "a", "b")
                .collect(Collectors.toSet());
        System.out.print(set1);                     //prints: [a, b]

        System.out.print("\n2.toCollection(TreeSet): ");
        Set<String> set2 = Stream.of("a", "a", "b")
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.print(set2);                     //prints: [a, b]

        System.out.print("\n1.toCollection(Vector): ");
        Vector<String> coll1 = Stream.of("a", "a", "b")
                .collect(Collectors.toCollection(Vector::new));
        System.out.print(coll1);                     //prints: [a, a, b]

        System.out.print("\n2.toCollection(Stack): ");
        Stack<String> coll2 = Stream.of("a", "a", "b")
                .collect(Collectors.toCollection(Stack::new));
        System.out.print(coll2);                     //prints: [a, a, b]
    }
}

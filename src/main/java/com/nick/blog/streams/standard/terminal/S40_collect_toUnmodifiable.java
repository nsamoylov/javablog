package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S40_collect_toUnmodifiable {  //since Java 10
    public static void main(String... args) {
        System.out.print("\n1.toUnmodifiableList(): ");
        List<String> list = Stream.of("a", "a", "b")
                .collect(Collectors.toUnmodifiableList());
        System.out.println(list);        //prints: [a, a, b]
        System.out.println(list.getClass().getName()); //prints: java.util.ImmutableCollections$ListN
        try {
            list.add("c");  //prints: UnsupportedOperationException
        } catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            //To allow exception stacktrace to be printed before the next System.out
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {}

        System.out.print("\n2.toUnmodifiableSet(): ");
        Set<String> set = Stream.of("a", "a", "b")
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(set);        //prints: [a, b]
        System.out.println(set.getClass().getName()); //prints: java.util.ImmutableCollections$Set12
        try {
            set.add("c");  //prints: UnsupportedOperationException
        } catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            //To allow exception stacktrace to be printed before the next System.out
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {}

        System.out.println("\n3.toUnmodifiableMap(): ");
        try {
            Map<String, Integer> map3= Stream.of("cat", "cat", "fish")
                    .collect(Collectors.toUnmodifiableMap(Function.identity(), String::length));
        } catch (Exception ex){
            ex.printStackTrace();  //IllegalStateException: Duplicate key cat (attempted merging values 3 and 3)
        }

        try {
            //To allow exception stacktrace to be printed before the next System.out
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {}

        System.out.print("\n4.toUnmodifiableMap(): ");
        Map<String, Integer> map4= Stream.of("cat", "cat", "fish")
                .collect(Collectors.toUnmodifiableMap(Function.identity(), String::length, (i1,i2) -> i1 == i2 ? i1 : i2 ));
        System.out.println(map4);        //prints: {cat=3, fish=4}
        System.out.println(map4.getClass().getName()); //prints: java.util.ImmutableCollections$MapN
        try {
            map4.put("c", 1);  //prints: UnsupportedOperationException
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

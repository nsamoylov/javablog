package com.nick.blog.streams.standard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class S15_FactoryMethods {
    public static void main(String... args) {
        System.out.print("1: ");
        Stream.empty().forEach(System.out::print); //prints nothing

        System.out.print("\n2: ");
        new ArrayList().forEach(System.out::print);          //prints nothing
        new ArrayList().stream().forEach(System.out::print); //prints nothing

        System.out.print("\n3: ");
        //printList1(null);             //NullPointerException

        printList1(new ArrayList());    //prints nothing

        List<String> list = List.of("1", "2");
        printList1(list);               //prints: 12

        System.out.print("\n4: ");
        Stream<Integer> stream1 = List.of(1, 2).stream();
        Stream<Integer> stream2 = List.of(2, 3).stream();
        Stream.concat(stream1, stream2).forEach(System.out::print); //prints: 1223
    }

    static void printList1(List<String> list) {
        list.stream().forEach(System.out::print);
    }

    static void printList2(List<String> list) {
        (list == null ? Stream.empty() : list.stream())
                .forEach(System.out::print);
    }

    static void printList3(List<String> list){
        Stream.ofNullable(list).flatMap(l -> l.stream())
                .forEach(System.out::print);
    }

    static void printList4(List<String> list){
        Stream.ofNullable(list).flatMap(Collection::stream)
            .forEach(System.out::print);
    }
}

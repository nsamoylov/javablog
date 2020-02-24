package com.nick.blog.streams.standard.factory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class S15_ofNullable {
    public static void main(String... args) {
        System.out.print("1: ");
        //printList1(null);             // NullPointerException

        System.out.print("\n2: ");
        printList2(null);               //prints nothing

        System.out.print("\n3: ");
        printList3(null);               //prints nothing

        System.out.print("\n4: ");
        printList4(null);               //prints nothing
    }

    private static void printList1(List<String> list){
        list.stream().forEach(System.out::print);
    }

    private static void printList2(List<String> list){
        (list == null ? Stream.empty() : list.stream())
                .forEach(System.out::print);
    }

    private static void printList3(List<String> list){
        Stream.ofNullable(list)
                .flatMap(l -> l.stream())
                .forEach(System.out::print);
    }

    private static void printList4(List<String> list){
        Stream.ofNullable(list).flatMap(Collection::stream)
                .forEach(System.out::print);
    }

}

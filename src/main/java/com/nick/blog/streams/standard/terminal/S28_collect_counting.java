package com.nick.blog.streams.standard.terminal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S28_collect_counting {
    public static void main(String... args) {
        System.out.print("\n1.count    without peek     : ");
        long c1 = Stream.of("cat", "fish", "dog")
                .count();
        System.out.print(c1);                      //prints: 3

        System.out.print("\n2.count    with peek        : ");
        long c2 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //is not called
                .count();
        System.out.print(c2);                       //prints: 3

        System.out.print("\n3.counting with peek        : ");
        long c3 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //prints: catfishdog
                .collect(Collectors.counting());
        System.out.print(c3);                      //prints: 3

        System.out.print("\n4.count    limit 1 with peek: ");
        long c4 = Stream.of("cat", "fish", "dog")
                .limit(1)
                .peek(s -> System.out.print(s))    //prints: cat
                .count();
        System.out.print(c4);                      //prints: 1

        System.out.print("\n5.counting limit 1 with peek: ");
        long c5 = Stream.of("cat", "fish", "dog")
                .limit(1)
                .peek(s -> System.out.print(s))    //prints: cat
                .collect(Collectors.counting());
        System.out.print(c5);                      //prints: 1

        System.out.print("\n6.count    with peek limit 1: ");
        long c6 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //prints: cat
                .limit(1)
                .count();
        System.out.print(c6);                      //prints: 1

        System.out.print("\n7.counting with peek limit 1: ");
        long c7 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //prints: cat
                .limit(1)
                .collect(Collectors.counting());
        System.out.print(c7);                       //prints: 1

        System.out.print("\n8.count    with peek counter: ");
        Counter counter8 = new Counter();
        long c8 = Stream.of("cat", "fish", "dog")
                .peek(s -> counter8.increment())   //not called
                .count();
        System.out.print(c8);                      //prints:3
        System.out.print(counter8.getCount());     //prints: 0

        System.out.print("\n9.counting with peek counter: ");
        Counter counter9 = new Counter();
        long c9 = Stream.of("cat", "fish", "dog")
                .peek(s -> counter9.increment())    //prints: cat
                .collect(Collectors.counting());
        System.out.print(c9);                      //prints: 3
        System.out.print(counter9.getCount());      //prints: 3
    }

    private static class Counter{
        long count;
        public void increment(){ this.count++; }
        public long getCount(){ return this.count; }
    }
}

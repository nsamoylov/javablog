package com.nick.blog.streams.standard.terminal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S26_collect_counting {
    public static void main(String... args) {
        System.out.print("1.count: ");
        long c1 = Stream.of("cat", "fish", "dog")
                .collect(Collectors.counting());
        System.out.print(c1);                      //prints: 3

        System.out.print("\n2.count: ");
        long c2 = Stream.of("cat", "fish", "dog")
                .count();
        System.out.print(c2);                      //prints: 3

        System.out.print("\n3.count: ");
        long c3 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //is not called
                .count();
        System.out.print(c3);                       //prints: 3

        System.out.print("\n4.count: ");
        long c4 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //prints: catfishdog
                .collect(Collectors.counting());
        System.out.print(c4);                      //prints: 3

        System.out.print("\n5.count: ");
        long c5 = Stream.of("cat", "fish", "dog")
                .limit(1)
                .peek(s -> System.out.print(s))    //prints: cat
                .count();
        System.out.print(c5);                      //prints: 1

        System.out.print("\n6.count: ");
        long c6 = Stream.of("cat", "fish", "dog")
                .limit(1)
                .peek(s -> System.out.print(s))    //prints: cat
                .collect(Collectors.counting());
        System.out.print(c6);                      //prints: 1

        System.out.print("\n7.count: ");
        long c7 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //prints: cat
                .limit(1)
                .count();
        System.out.print(c7);                      //prints: 1

        System.out.print("\n8.count: ");
        long c8 = Stream.of("cat", "fish", "dog")
                .peek(s -> System.out.print(s))    //prints: cat
                .limit(1)
                .collect(Collectors.counting());
        System.out.print(c8);                       //prints: 1

        System.out.print("\n9.count: ");
        Counter counter1 = new Counter();
        long c9 = Stream.of("cat", "fish", "dog")
                .peek(s -> counter1.increment())   //not called
                .count();
        System.out.print(c9);                      //prints:3
        System.out.print(counter1.getCount());     //prints: 0

        System.out.print("\n10.count: ");
        Counter counter2 = new Counter();
        long c10 = Stream.of("cat", "fish", "dog")
                .peek(s -> counter2.increment())    //prints: cat
                .collect(Collectors.counting());
        System.out.print(c10);                      //prints: 3
        System.out.print(counter2.getCount());      //prints: 3
    }

    private static class Counter{
        long count;
        public void Count(){}
        public void increment(){ this.count++; }
        public long getCount(){ return this.count; }
    }
}

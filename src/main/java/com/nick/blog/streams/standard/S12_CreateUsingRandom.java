package com.nick.blog.streams.standard;

import java.util.Random;

public class S12_CreateUsingRandom {
    public static void main(String... args) {
        System.out.print("1: ");
        new Random().ints()
                .limit(3)
                .forEach(i -> System.out.print(i + " ")); //prints: 729828546 -1094812726 -882682722 (different for each run)

        System.out.print("\n2: ");
        new Random().ints(3)
                    .forEach(i -> System.out.print(i + " ")); //prints: -1989654223 -774535445 1381816175 (different for each run)

        System.out.print("\n3: ");
        new Random().ints(0, 10)
                    .limit(3)
                    .forEach(i -> System.out.print(i + " "));  //prints: 4 6 1 (different for each run)

        System.out.print("\n4: ");
        new Random().ints(3, 0, 10)
                    .forEach(i -> System.out.print(i + " "));  //prints: 3 4 7 (different for each run)
    }
}

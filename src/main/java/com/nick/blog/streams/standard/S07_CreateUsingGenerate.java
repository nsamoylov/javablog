package com.nick.blog.streams.standard;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class S07_CreateUsingGenerate {
    public static void main(String... args) {
        System.out.print("1: ");
        Stream<String> streamX = Stream.generate(new SupplierImpl());
        streamX.limit(5).forEach(System.out::print);         //prints: xxxxx

        System.out.print("\n2: ");
        Stream<String> streamX2 = Stream.generate(() -> "x");
        streamX2.limit(5).forEach(System.out::print);   //prints: xxxxx

        System.out.print("\n3: ");
        Stream<Integer> stream = Stream.generate(new Random()::nextInt);
        stream.limit(2)
                .map(i -> i.toString() + " ")
                .forEach(System.out::print);  //prints: -1097315144 1639784147 (differs every run)

        System.out.print("\n4: ");
        Stream.generate(new Random()::nextInt)
                .limit(2)
                .map(i -> i.toString() + " ")
                .forEach(System.out::print);  //prints: -288126400 -872136567 (differs every run)

        System.out.print("\n5: ");
        Stream.generate(new SupplierImpl2()::get)
                .limit(5)
                .forEach(System.out::print);    //prints: 12345

        System.out.print("\n6: ");
        Stream.generate(new DemoClass()::calculateString)
                .limit(5)
                .forEach(System.out::print);    //prints: 12345

        System.out.print("\n7: ");
        Stream.generate(DemoClass2::calculateString)
                .limit(5)
                .forEach(System.out::print);    //prints: 12345
    }

    private static class SupplierImpl implements Supplier<String> {
        public String get(){
            return "x";
        }
    }

    private static class SupplierImpl2 implements Supplier<String>{
        private static int count = 1;
        public String get(){
            return String.valueOf(count++);
        }
    }

    private static class DemoClass {
        private static int count = 1;
        public String calculateString(){
            return String.valueOf(count++);
        }
    }

    private static class DemoClass2 {
        private static int count = 1;
        public static String calculateString(){
            return String.valueOf(count++);
        }
    }
}

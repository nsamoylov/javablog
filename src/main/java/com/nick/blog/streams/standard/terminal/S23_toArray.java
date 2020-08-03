package com.nick.blog.streams.standard.terminal;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class S23_toArray {
    public static void main(String... args) {
        System.out.print("\n1: ");
        Object[] res1 = Stream.of("a", "b", "c")
                .map(String::toUpperCase)
                .toArray();
        System.out.print(Arrays.toString(res1));   //prints: [A, B, C]

        System.out.print("\n2: ");
        IntFunction<String[]> f1 = i -> new String[i];
        System.out.print(Arrays.toString(f1.apply(3)));   //prints: [null, null, null]

        System.out.print("\n3: ");
        IntFunction<String[]> f2 = i -> new String[i];
        String[] res3 = Stream.of("a", "b", "c")
                .map(String::toUpperCase)
                .toArray(f2);
        System.out.print(Arrays.toString(res3));   //prints: [A, B, C]

        System.out.print("\n4: ");
        String[] res4 = Stream.of("a", "b", "c")
                .map(String::toUpperCase)
                .toArray(i -> new String[i]);
        System.out.print(Arrays.toString(res4));   //prints: [A, B, C]

        System.out.print("\n5: ");
        String[] res5 = Stream.of("a", "b", "c")
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.print(Arrays.toString(res5));   //prints: [A, B, C]

        System.out.print("\n6: ");
        Person[] res6 = Stream.of("a", "b", "c")
                .map(s -> createPerson(s))
                .toArray(Person[]::new);
        System.out.print(Arrays.toString(res6));   //prints: [Person{Alex}, Person{Bernie}, Person{Carol}]

        System.out.print("\n7: ");
        Integer[] res7 = Stream.of("a", "b", "c")
                .map(s -> createPerson(s))
                .map(p -> p.getName().length())
                .toArray(Integer[]::new);
        System.out.print(Arrays.toString(res7));   //prints: [4, 6, 5]

        System.out.print("\n8: ");
        Integer[] res8 = Stream.of("a", "b", "c")
                .map(s -> createPerson(s).getName().length())
                .toArray(Integer[]::new);
        System.out.print(Arrays.toString(res8));   //prints: [4, 6, 5]

        System.out.print("\n9: ");
        int[] res9 = Stream.of("a", "b", "c")
                .map(s -> createPerson(s).getName().length())
                .mapToInt(i -> i)
                .toArray();
        System.out.print(Arrays.toString(res9));   //prints: [4, 6, 5]

        System.out.print("\n10: ");
        int[] res10 = Stream.of("a", "b", "c")
                .mapToInt(s -> createPerson(s).getName().length())
                .toArray();
        System.out.print(Arrays.toString(res10));   //prints: [4, 6, 5]
    }

    private static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        @Override
        public String toString() {
            return "Person{" + name + "}";
        }
    }

    public static Person createPerson(String s){
        switch (s){
            case "a":
                return new Person("Alex");
            case "b":
                return new Person("Bernie");
            case "c":
                return new Person("Carol");
            default:
                return new Person("Zoi");
        }
    }

}

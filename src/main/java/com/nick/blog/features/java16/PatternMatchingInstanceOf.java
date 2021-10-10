package com.nick.blog.features.java16;

import java.util.Objects;

public class PatternMatchingInstanceOf {
    public static void main(String... args) {
        Object obj = new Person(25, "Bill", "Smith");

        if (obj instanceof Person) {
            Person p = (Person) obj;
            System.out.println(p.firstName());   //prints: Bill
        }

        if (obj instanceof Person p) {
            System.out.println(p.firstName());   //prints: Bill
        }
    }

    private record Person(int age, String firstName, String lastName){}
}

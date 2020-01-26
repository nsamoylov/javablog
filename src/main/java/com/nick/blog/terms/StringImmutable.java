package com.nick.blog.terms;

public class StringImmutable {
    public static void main(String... args) {
        newString();
        literals();
    }

    private static void literals() {
        String s1 = "s1";
        String s2 = "s1";

        System.out.println(s1 == s2);          // true
        System.out.println(s1.equals(s2));     // true

        System.out.println(s1 == "s1");        // true
        System.out.println("s1" == "s1");      // true

        System.out.println(s1.equals("s1"));   // true
        System.out.println("s1".equals("s1")); // true

        s2 = s1.concat(" changed");
        System.out.println(s1);        // s1
        System.out.println(s2);        // s1 changed

        String s3 = s1.concat(" changed");
        System.out.println(s2 == s3);  // false
    }

    private static void newString() {

        String s1 = new String("s1");
        String s2 = new String("s1");


        System.out.println(s1 == s2);       // false
        System.out.println(s1.equals(s2));  // true
    }

}

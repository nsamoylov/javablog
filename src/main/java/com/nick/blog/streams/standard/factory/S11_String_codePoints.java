package com.nick.blog.streams.standard.factory;

public class S11_String_codePoints {
    public static void main(String... args) {
        String supplString = new String(Character.toChars(0x1F600));

        System.out.print("1: ");
        supplString.codePoints().forEach(System.out::print);     //prints: 128512

        System.out.print("\n2: ");
        supplString.codePoints().forEach(c -> System.out.print((char) c));  //prints: 

        System.out.print("\n3: ");
        supplString.codePoints().forEach(c -> System.out.print(Character.toChars(c))); //prints: 😀
    }
}

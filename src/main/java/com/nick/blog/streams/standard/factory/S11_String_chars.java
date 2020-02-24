package com.nick.blog.streams.standard.factory;

import java.util.Arrays;
import java.util.stream.IntStream;

public class S11_String_chars {
    public static void main(String... args) {
        System.out.print("1: ");
        IntStream intStream = "abc".chars();
        intStream.forEach(i -> System.out.print(i + " ")); //prints: 97 98 99

        System.out.print("\n2: ");
        IntStream intStream2 = "abc".chars();
        intStream2.mapToObj(c -> (char)c)
                .forEach(i -> System.out.print(i + " "));  //prints: a b c

        System.out.print("\n3: ");
        int[] chars = "abcDeF".chars()
                .filter(c -> c < 97)  // avoids boxing into Character
                .toArray();

        Arrays.stream(chars)
                .forEach(c -> System.out.print(c + " ")); //prints: 68 70

        System.out.print("\n4: ");
        Arrays.stream(chars)
                .forEach(c -> System.out.print((char)c + " ")); //prints: D F

        System.out.print("\n5: ");
        System.out.print('a' > Character.MIN_SUPPLEMENTARY_CODE_POINT);      //prints: false

        System.out.print("\n6: ");
        System.out.print(0x1F600 > Character.MIN_SUPPLEMENTARY_CODE_POINT); //prints: true

        System.out.print("\n7: ");
        String supplString = new String(Character.toChars(0x1F600));
        System.out.print(supplString);    //prints: 😀

        System.out.print("\n8: ");
        //String supplString = new String(Character.toChars(0x1F600) );
        supplString.chars().forEach(c -> System.out.println(c));  //prints: 55357 56832

        System.out.print("\n9: ");
        supplString.chars().forEach(c -> System.out.println((char)c)); //prints: ? ?

        System.out.print("\n10: ");
        supplString.chars().forEach(c -> System.out.println(Character.toChars(c))); //prints: ? ?

    }
}

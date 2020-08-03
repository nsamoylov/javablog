package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class x08_Operation_orElseThrow {
    public static void main(String... args){
        System.out.print("\n1: ");
        try {
            String result = Optional.of("1")
                    .orElseThrow();
            System.out.println(result);      //prints: 1
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.print("\n2: ");
        try {
            String result = Optional.of("1")
                    .filter(s -> s.equals("2"))
                    .orElseThrow();          //NoSuchElementException
            System.out.println(result);
        } catch (Exception ex){
            ex.printStackTrace();
            sleepMs(200);
        }

        System.out.print("\n3: ");
        Supplier<Exception> generateException = () -> new RuntimeException("No value!");
        try {
            String result = Optional.of("1")
                    .orElseThrow(generateException);
            System.out.println(result);      //prints: 1
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.print("\n4: ");
        try {
            String result = Optional.of("1")
                    .filter(s -> s.equals("2"))
                    .orElseThrow(generateException);  //RuntimeException: No value!
            System.out.println(result);
        } catch (Exception ex){
            ex.printStackTrace();
            sleepMs(200);
        }
    }

    private static void sleepMs(long ms){
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

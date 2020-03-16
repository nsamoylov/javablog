package com.nick.blog.streams.standard.terminal.S21_Optional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class x04_Properties {
    public static void main(String... args){
        System.out.print("Optional.of(\"1\"): ");
        Optional<String> opt1 = Optional.of("1");
        System.out.print("\n  .get(): ");
        System.out.print(opt1.get());          //prints: 1

        System.out.print("\n  .isEmpty(): ");
        System.out.print(opt1.isEmpty());      //prints: false

        System.out.print("\n  .isPresent(): ");
        System.out.print(opt1.isPresent());    //prints: true


        System.out.print("\n\nOptional.ofNullable(null): ");
        Optional<String> opt2 = Optional.ofNullable(null);
        System.out.print("\n  .get(): ");
        try {
            System.out.print(opt2.get());    //throws NoSuchElementException
        } catch (Exception ex){
            ex.printStackTrace();
            sleepMs(200);
        }

        System.out.print("  .isEmpty(): ");
        System.out.print(opt2.isEmpty());       //prints: true

        System.out.print("\n  .isPresent(): ");
        System.out.print(opt2.isPresent());     //prints: false


        System.out.print("\n\nOptional.ofNullable(\"1\"): ");
        Optional<String> opt3 = Optional.ofNullable("1");
        System.out.print("\n  .get(): ");
        System.out.print(opt3.get());           //prints: 1

        System.out.print("\n  .isEmpty(): ");
        System.out.print(opt3.isEmpty());      //prints: false

        System.out.print("\n  .isPresent(): ");
        System.out.print(opt3.isPresent());    //prints: true


        System.out.print("\n\nOptional.empty(): ");
        Optional<String> opt4 = Optional.empty();
        System.out.print("\n  .get(): ");
        try {
            System.out.print(opt4.get());    //throws NoSuchElementException
        } catch (Exception ex){
            ex.printStackTrace();
            sleepMs(200);
        }

        System.out.print("  .isEmpty(): ");
        System.out.print(opt4.isEmpty());        //prints: true

        System.out.print("\n  .isPresent(): ");
        System.out.print(opt4.isPresent());      //prints: false
    }

    private static void sleepMs(long ms){
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.nick.blog.features.java16;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DayPeriod {
    public static void main(String... args){
        System.out.print("1: ");
        periodOfDay("05:05:18.123456", "h a"); //prints: 5 AM

        System.out.print("\n2: ");
        periodOfDay("05:05:18.123456", "h B"); //prints: 5 at night

        System.out.print("\n3: ");
        periodOfDay("06:05:18.123456", "h B"); //prints: 6 in the morning

        System.out.print("\n4: ");
        periodOfDay("11:05:18.123456", "h B"); //prints: 11 in the morning

        System.out.print("\n5: ");
        periodOfDay("12:05:18.123456", "h B"); //prints: 12 in the afternoon

        System.out.print("\n6: ");
        periodOfDay("17:05:18.123456", "h B"); //prints: 5 in the afternoon

        System.out.print("\n7: ");
        periodOfDay("18:05:18.123456", "h B"); //prints: 6 in the evening

        System.out.print("\n8: ");
        periodOfDay("20:05:18.123456", "h B"); //prints: 8 in the evening

        System.out.print("\n9: ");
        periodOfDay("21:05:18.123456", "h B"); //prints: 9 at night
    }

    private static void periodOfDay(String time, String pattern){
        LocalTime date = LocalTime.parse(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        System.out.print(date.format(formatter));
    }

 }

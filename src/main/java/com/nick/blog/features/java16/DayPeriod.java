package com.nick.blog.features.java16;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DayPeriod {
    public static void main(String... args){
        System.out.print("1: ");
        periodOfDayFromDateTime("2023-03-23T05:05:18.123456", "MM-dd-yyyy h a");
                                                                     //prints: 03-23-2023 5 AM

        System.out.print("\n2: ");
        periodOfDayFromDateTime("2023-03-23T05:05:18.123456", "MM-dd-yyyy h B");
                                                               //prints: 03-23-2023 5 at night

        System.out.print("\n3: ");
        periodOfDayFromDateTime("2023-03-23T06:05:18.123456", "h B");
                                                                     //prints: 6 in the morning

        System.out.print("\n4: ");
        periodOfDayFromTime("11:05:18.123456", "h B"); //prints: 11 in the morning

        System.out.print("\n5: ");
        periodOfDayFromTime("12:05:18.123456", "h B"); //prints: 12 in the afternoon

        System.out.print("\n6: ");
        periodOfDayFromTime("17:05:18.123456", "h B"); //prints: 5 in the afternoon

        System.out.print("\n7: ");
        periodOfDayFromTime("18:05:18.123456", "h B"); //prints: 6 in the evening

        System.out.print("\n8: ");
        periodOfDayFromTime("20:05:18.123456", "h B"); //prints: 8 in the evening

        System.out.print("\n9: ");
        periodOfDayFromTime("21:05:18.123456", "h B"); //prints: 9 at night
    }

    private static void periodOfDayFromDateTime(String time, String pattern){
        LocalDateTime date = LocalDateTime.parse(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        System.out.print(date.format(formatter));
    }

    private static void periodOfDayFromTime(String time, String pattern){
        LocalTime date = LocalTime.parse(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        System.out.print(date.format(formatter));
    }
}

package com.nick.blog.streams.standard.terminal;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S27_collect_summarizing {
    public static void main(String... args) {
        System.out.print("\n1.IntStream.sum(): ");
        Integer sumInt1 = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.print(sumInt1);                      //prints: 15

        System.out.print("\n2.Collectors.summingInt(): ");
        Integer sumInt2 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.print(sumInt2);                      //prints: 15

        System.out.print("\n3.IntStream.sum(): ");
        Integer sumInt3 = Stream.of("abc", "a", "xy")
                .mapToInt(s -> s.length())
                .sum();
        System.out.print(sumInt3);                      //prints: 6

        System.out.print("\n4.Collectors.summingInt(): ");
        Integer sumInt4 = Stream.of("abc", "a", "xy")
                .collect(Collectors.summingInt(s -> s.length()));
        System.out.print(sumInt4);                      //prints: 6

        System.out.print("\n5.Collectors.summingInt(): ");
        Integer sumInt5 = Stream.of("abc", "a", "xy")
                .collect(Collectors.collectingAndThen(Collectors.summingInt(s -> s.length()), i -> i * i));
        System.out.print(sumInt5);                      //prints: 36

        System.out.print("\n6.LongStream.sum(): ");
        Long sumLong1 = Stream.of(1L, 2L, 3L, 4L, 5L)
                .mapToLong(Long::longValue)
                .sum();
        System.out.print(sumLong1);                      //prints: 15

        System.out.print("\n7.Collectors.summingLong(): ");
        Long sumLong2 = Stream.of(1L, 2L, 3L, 4L, 5L)
                .collect(Collectors.summingLong(Long::longValue));
        System.out.print(sumLong2);                      //prints: 15

        System.out.print("\n8.DoubleStream.sum(): ");
        Double sumDouble1 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0)
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.print(sumDouble1);                      //prints: 15.0

        System.out.print("\n9.Collectors.summingDouble(): ");
        Double sumDouble2 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0)
                .collect(Collectors.summingDouble(Double::doubleValue));
        System.out.print(sumDouble2);                      //prints: 15.0

        System.out.print("\n\n1.IntStream.average(): ");
        Double aveInt1 = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.print(aveInt1);                      //prints: 3.0

        System.out.print("\n2.Collectors.averagingInt(): ");
        Double aveInt2 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.print(aveInt2);                      //prints: 3.0

        System.out.print("\n3.IntStream.average(): ");
        Double aveInt3 = Stream.of("abc", "a", "xy")
                .mapToInt(s -> s.length())
                .average()
                .getAsDouble();
        System.out.print(aveInt3);                      //prints: 2.0

        System.out.print("\n4.Collectors.averagingInt(): ");
        Double aveInt4 = Stream.of("abc", "a", "xy")
                .collect(Collectors.averagingInt(s -> s.length()));
        System.out.print(aveInt4);                      //prints: 2.0

        System.out.print("\n5.Collectors.averagingInt(): ");
        Double aveInt5 = Stream.of("abc", "a", "xy")
                .collect(Collectors.collectingAndThen(Collectors.averagingInt(s -> s.length()), i -> i * i));
        System.out.print(aveInt5);                      //prints: 4.0

        System.out.print("\n6.LongStream.average(): ");
        Double aveLong1 = Stream.of(1L, 2L, 3L, 4L, 5L)
                .mapToLong(Long::longValue)
                .average()
                .getAsDouble();
        System.out.print(aveLong1);                      //prints: 3.0

        System.out.print("\n7.Collectors.averagingLong(): ");
        Double aveLong2 = Stream.of(1L, 2L, 3L, 4L, 5L)
                .collect(Collectors.averagingLong(Long::longValue));
        System.out.print(aveLong2);                      //prints: 3.0

        System.out.print("\n8.DoubleStream.average(): ");
        Double aveDouble1 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0)
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
        System.out.print(aveDouble1);                      //prints: 3.0

        System.out.print("\n9.Collectors.averagingDouble(): ");
        Double aveDouble2 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0)
                .collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.print(aveDouble2);                      //prints: 3.0

        System.out.println("\n\n1.IntStream.summaryStatistics(): ");
        IntSummaryStatistics smrInt1 = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("   cnt " + smrInt1.getCount());           //prints: 5
        System.out.println("   min " + smrInt1.getMin());             //prints: 1
        System.out.println("   max " + smrInt1.getMax());             //prints: 5
        System.out.println("   ave " + smrInt1.getAverage());         //prints: 3.0
        System.out.println("   sum " + smrInt1.getSum());             //prints: 15

        System.out.println("\n2.Collectors.summarizingInt(): ");
        IntSummaryStatistics smrInt2 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("   cnt " + smrInt2.getCount());           //prints: 5
        System.out.println("   min " + smrInt2.getMin());             //prints: 1
        System.out.println("   max " + smrInt2.getMax());             //prints: 5
        System.out.println("   ave " + smrInt2.getAverage());         //prints: 3.0
        System.out.println("   sum " + smrInt2.getSum());             //prints: 15

        System.out.println("\n3.LongStream.summaryStatistics(): ");
        LongSummaryStatistics smrLong1 = Stream.of(1L, 2L, 3L, 4L, 5L)
                .mapToLong(Long::longValue)
                .summaryStatistics();
        System.out.println("   cnt " + smrLong1.getCount());           //prints: 5
        System.out.println("   min " + smrLong1.getMin());             //prints: 1
        System.out.println("   max " + smrLong1.getMax());             //prints: 5
        System.out.println("   ave " + smrLong1.getAverage());         //prints: 3.0
        System.out.println("   sum " + smrLong1.getSum());             //prints: 15

        System.out.println("\n4.Collectors.summarizingLong(): ");
        LongSummaryStatistics smrLong2 = Stream.of(1L, 2L, 3L, 4L, 5L)
                .collect(Collectors.summarizingLong(Long::longValue));
        System.out.println("   cnt " + smrLong2.getCount());           //prints: 5
        System.out.println("   min " + smrLong2.getMin());             //prints: 1
        System.out.println("   max " + smrLong2.getMax());             //prints: 5
        System.out.println("   ave " + smrLong2.getAverage());         //prints: 3.0
        System.out.println("   sum " + smrLong2.getSum());             //prints: 15

        System.out.println("\n5.DoubleStream.summaryStatistics(): ");
        DoubleSummaryStatistics smrDouble1 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0)
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();
        System.out.println("   cnt " + smrDouble1.getCount());           //prints: 5
        System.out.println("   min " + smrDouble1.getMin());             //prints: 1.0
        System.out.println("   max " + smrDouble1.getMax());             //prints: 5.0
        System.out.println("   ave " + smrDouble1.getAverage());         //prints: 3.0
        System.out.println("   sum " + smrDouble1.getSum());             //prints: 15.0

        System.out.println("\n6.Collectors.summarizingDouble(): ");
        DoubleSummaryStatistics smrDouble2 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("   cnt " + smrDouble2.getCount());           //prints: 5
        System.out.println("   min " + smrDouble2.getMin());             //prints: 1.0
        System.out.println("   max " + smrDouble2.getMax());             //prints: 5.0
        System.out.println("   ave " + smrDouble2.getAverage());         //prints: 3.0
        System.out.println("   sum " + smrDouble2.getSum());             //prints: 15.0
    }

}

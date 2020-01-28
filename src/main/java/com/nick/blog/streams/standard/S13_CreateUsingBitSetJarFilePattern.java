package com.nick.blog.streams.standard;

import java.io.File;
import java.nio.file.Path;
import java.util.BitSet;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

public class S13_CreateUsingBitSetJarFilePattern {
    public static void main(String... args) {
        System.out.println("1: ");
        BitSet bs = new BitSet();
        bs.set(63);
        System.out.println(bs.size());          //prints: 64
        System.out.println(bs.cardinality());   //prints: 1
        System.out.println(bs.length());        //prints: 64
        bs.set(64);
        System.out.println(bs.size());          //prints: 128
        System.out.println(bs.cardinality());   //prints: 2
        System.out.println(bs.length());        //prints: 65

        System.out.println("\n2: ");
        BitSet bs1 = new BitSet();
        bs1.set(1);
        bs1.set(3);
        printFourBits(bs1);       //prints: 0101

        BitSet bs2 = new BitSet();
        bs2.set(3);
        printFourBits(bs2);       //prints: 0001

        bs1.and(bs2);   //bitwise AND
        printFourBits(bs1);       //prints: 0001

        bs1 = new BitSet();
        bs1.set(1);
        bs1.set(3);
        printFourBits(bs1);       //prints: 0101

        bs2 = new BitSet();
        bs2.set(3);
        printFourBits(bs2);       //prints: 0001

        bs1.or(bs2);   //bitwise OR
        printFourBits(bs1);       //prints: 0101

        System.out.println("\n3: ");
        bs = new BitSet();
        bs.set(9);
        bs.set(3);
        bs.set(9);
        bs.set(7);
        System.out.println(bs);                 //prints: {3, 7, 9}
        bs.stream().forEach(System.out::print); //prints: 379

        System.out.println("\n\n4: ");
        Path path = Path.of("src", "main", "resources", "javablog-1.0.jar");
        File file = new File(path.toString());
        try (JarFile jf = new JarFile(file)){
            jf.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n5: ");
        Pattern pattern = Pattern.compile("[\\,\\.\\-]");
        pattern.splitAsStream("one-two,three.four")
                .forEach(System.out::println);
    }

    private static void printFourBits(BitSet bs) {
        String b0 = bs.get(0) ? "1" : "0";
        String b1 = bs.get(1) ? "1" : "0";
        String b2 = bs.get(2) ? "1" : "0";
        String b3 = bs.get(3) ? "1" : "0";
        System.out.println(b0 + b1 + b2 + b3);
    }
}
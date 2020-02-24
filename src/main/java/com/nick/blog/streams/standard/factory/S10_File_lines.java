package com.nick.blog.streams.standard.factory;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class S10_File_lines {
    public static void main(String... args) {
        System.out.println("1: ");
        Path filePath =
                Path.of("src", "main", "resources", "files", "lines.txt");
        try(Stream<String> linesStream = Files.lines(filePath)){
            linesStream.forEach(System.out::println);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("\n2: ");
        Charset cs = StandardCharsets.US_ASCII;
        try(Stream<String> linesStream = Files.lines(filePath, cs)){
            linesStream.forEach(System.out::println);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("\n3: ");
        Charset cs2 = StandardCharsets.UTF_16BE;
        try(Stream<String> linesStream = Files.lines(filePath, cs2)){
            linesStream.forEach(System.out::println);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

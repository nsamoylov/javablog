package com.nick.blog.streams.standard;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class S10_CreateFromFile {
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

        System.out.println("\n4: ");
        Path dir = Path.of("src", "main", "resources", "files");
        try(Stream<Path> dirStream = Files.list(dir)){
            dirStream.forEach(System.out::println);
        } catch (NotDirectoryException ex){
            System.out.println("The " + dir + " is not a directory.");;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("\n5: ");
        //Path dir = Path.of("src", "main", "resources", "files");
        try(Stream<Path> dirStream = Files.walk(dir,
                FileVisitOption.FOLLOW_LINKS)){
            dirStream.forEach(System.out::println);
        } catch (NotDirectoryException ex){
            System.out.println("The " + dir + " is not a directory.");;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("\n6: ");
        //Path dir = Path.of("src", "main", "resources", "files");
        try(Stream<Path> linesStream = Files.walk(dir, 2,
                FileVisitOption.FOLLOW_LINKS)){
            linesStream.forEach(System.out::println);
        } catch (NotDirectoryException ex){
            System.out.println("The " + dir + " is not a directory.");;
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

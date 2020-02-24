package com.nick.blog.streams.standard.factory;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class S10_File_walk {
    public static void main(String... args) {
        Path dir = Path.of("src", "main", "resources", "files");

        System.out.println("1: ");
        try(Stream<Path> dirStream = Files.walk(dir, FileVisitOption.FOLLOW_LINKS)){
            dirStream.forEach(System.out::println);
        } catch (NotDirectoryException ex){
            System.out.println("The " + dir + " is not a directory.");;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("\n2: ");
        try(Stream<Path> linesStream = Files.walk(dir, 2, FileVisitOption.FOLLOW_LINKS)){
            linesStream.forEach(System.out::println);
        } catch (NotDirectoryException ex){
            System.out.println("The " + dir + " is not a directory.");;
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

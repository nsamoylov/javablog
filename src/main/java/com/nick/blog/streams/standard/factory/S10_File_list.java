package com.nick.blog.streams.standard.factory;

import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class S10_File_list {
    public static void main(String... args) {

        Path dir = Path.of("src", "main", "resources", "files");
        try(Stream<Path> dirStream = Files.list(dir)){
            dirStream.forEach(System.out::println);
        } catch (NotDirectoryException ex){
            System.out.println("The " + dir + " is not a directory.");;
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

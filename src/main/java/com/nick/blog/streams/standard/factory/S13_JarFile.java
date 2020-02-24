package com.nick.blog.streams.standard.factory;

import java.io.File;
import java.nio.file.Path;
import java.util.jar.JarFile;

public class S13_JarFile {
    public static void main(String... args) {
        System.out.println("1: ");
        Path path = Path.of("src", "main", "resources", "javablog-1.0.jar");
        File file = new File(path.toString());
        try (JarFile jf = new JarFile(file)) {
            jf.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

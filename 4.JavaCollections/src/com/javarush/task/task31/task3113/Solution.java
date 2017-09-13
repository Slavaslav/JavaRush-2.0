package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathToFile = bufferedReader.readLine();
        bufferedReader.close();
        Path path = Paths.get(pathToFile);
        if (!Files.isDirectory(path)) {
            System.out.println(String.format("%s - не папка", pathToFile));
        } else {
            final int[] countDirectories = {0};
            final int[] countFiles = {0};
            final long[] size = {0};
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    countDirectories[0]++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countFiles[0]++;
                    size[0] += Files.size(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println(String.format("Всего папок - %d", countDirectories[0] - 1));
            System.out.println(String.format("Всего файлов - %d", countFiles[0]));
            System.out.println(String.format("Общий размер - %d", size[0]));

        }
    }
}
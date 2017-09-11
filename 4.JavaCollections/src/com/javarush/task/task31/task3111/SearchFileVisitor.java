package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean match = true;
        if (Objects.nonNull(partOfName)) {
            match = file.getFileName().toString().contains(partOfName);
        }

        if (match) {
            if (Objects.nonNull(partOfContent)) {
                List<String> strings = Files.readAllLines(file);
                for (String s : strings) {
                    if (s.contains(partOfContent)) {
                        break;
                    }
                    match = false;
                }

            }
        }

        if (match) {
            long fileSize = Files.size(file);
            if (fileSize < minSize) {
                match = false;
            }
            if (match && fileSize > maxSize) {
                match = false;
            }
        }

        if (match) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }
}
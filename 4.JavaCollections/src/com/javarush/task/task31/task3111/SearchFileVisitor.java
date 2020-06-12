package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
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

    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean nameSearch = true;
        boolean contentSearch = true;
        boolean minSizeSearch = true;
        boolean maxSizeSearch = true;
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        List<String> allLines = Files.readAllLines(file);
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            nameSearch = false;
        }
        if (partOfContent != null) {
            boolean test = false;
            for(String line : allLines) {
                if (line.contains(partOfContent)) {
                    test = true;
                }
            }
            contentSearch = test;
        }
        if (content.length <= minSize) {
            minSizeSearch = false;
        }
        if (maxSize != 0 && content.length >= maxSize) {
            maxSizeSearch = false;
        }
        if(nameSearch && contentSearch && minSizeSearch &&maxSizeSearch) {
            foundFiles.add(file);
        }

//        return super.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
    }
}

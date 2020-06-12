package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        boolean hidden = false;
        boolean executable = false;
        boolean directory = false;
        boolean writable = false;
        try {
            Path file = Paths.get(pathToFile);
            if (Files.isDirectory(file)) {
                directory = true;
            }
            if (Files.isHidden(file)) {
                hidden = true;
            }
            if (Files.isExecutable(file)) {
                executable = true;
            }
            if (Files.isWritable(file)) {
                writable = true;
            }
            fileData = new ConcreteFileData(hidden, executable, directory, writable);
        } catch (IOException e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}

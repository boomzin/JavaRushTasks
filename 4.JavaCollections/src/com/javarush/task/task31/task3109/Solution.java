package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Predicate;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Path file = Paths.get(fileName);
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file.toAbsolutePath().toString());
            String extension = file.getFileName().toString().substring(file.getFileName().toString().lastIndexOf(".") + 1);
            if (extension.equals("xml")) {
                property.loadFromXML(fileInputStream);
            } else {
                property.load(fileInputStream);
            }
            return property;
        } catch (IOException e) {
            return property;
        }
    }
}

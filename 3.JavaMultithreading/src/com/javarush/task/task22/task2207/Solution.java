package com.javarush.task.task22.task2207;

import sun.nio.cs.UTF_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        Path path = Paths.get(fileName);
        List<String> strings = Files.readAllLines(path, Charset.defaultCharset());
        List<String> words = new ArrayList<>();
        for (String string : strings) {
            words.addAll(Arrays.asList(string.split(" ")));
        }
        while (words.size() > 0) {
            String first = words.remove(0);
            String second = new StringBuilder(first).reverse().toString();
            if (words.contains(second)) {
                words.remove(second);
                Pair pair = new Pair();
                pair.first = first;
                pair.second = second;
                result.add(pair);
            }
        }
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

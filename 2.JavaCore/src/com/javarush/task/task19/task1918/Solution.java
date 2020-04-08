package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> taggedLine = new ArrayList<>();
    public static String openTag = "<";
    public static String closeTag = "</";

    public static void main(String[] args) throws IOException {
        String tag = args[0];
        openTag += tag;
        closeTag += tag + ">";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fl = new FileReader(fileName);
        BufferedReader bf = new BufferedReader(fl);
        String tmpString = "";
        String readyLine = "";
        while ((tmpString = bf.readLine()) != null) {
            readyLine = readyLine + tmpString;
            int openTagCount = tagCount(readyLine, openTag);
            int closeTagCount = tagCount(readyLine, closeTag);
            if ((openTagCount == closeTagCount) & (openTagCount != 0)) {
                tagged(readyLine);
                readyLine = "";
            }
        }
        fl.close();
        bf.close();

        for (int i = 0; i < taggedLine.size(); i++) {
            System.out.println(taggedLine.get(i));
        }
    }

    public static void tagged (String s) {
        int i = s.indexOf(openTag);
        int indexOpenTag = s.indexOf(openTag);
        int indexCloseTag = s.indexOf(closeTag) + closeTag.length();
        while (true) {
            if (! (tagCount(s.substring(indexOpenTag, indexCloseTag), openTag) == tagCount(s.substring(indexOpenTag, indexCloseTag), closeTag))) {
                indexCloseTag = s.indexOf(closeTag, indexCloseTag) + closeTag.length();
            } else {
                taggedLine.add(s.substring(indexOpenTag, indexCloseTag));
                if (s.substring(indexOpenTag + openTag.length(), indexCloseTag).contains(openTag)) {
                    tagged(s.substring(indexOpenTag + openTag.length(), indexCloseTag - closeTag.length()));
                }
                if (s.substring(indexCloseTag).contains(openTag)) {
                    tagged(s.substring(indexCloseTag));
                }
                return;
            }
        }
    }

    public static int tagCount (String string, String tag) {
        String [] taggedArray = (" " + string + " ").split(tag);
        return taggedArray.length - 1;
    }
}

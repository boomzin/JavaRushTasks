package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = fileNameReader.readLine();
        String targetFile = fileNameReader.readLine();
        fileNameReader.close();

        FileReader readerSourceFile = new FileReader(sourceFile);//, Charset.forName("Cp1251"));
        BufferedReader bufferedReaderSource = new BufferedReader(readerSourceFile);
        List <String> sourceList = new ArrayList<>();
        while (bufferedReaderSource.ready()) {
            String tempSource = bufferedReaderSource.readLine();
            sourceList.add(tempSource);
//            System.out.println(tempSource);
        }
        bufferedReaderSource.close();

        FileReader readerTarget = new FileReader(targetFile);//, Charset.forName("Cp1251"));
        BufferedReader bufferedReaderTarget = new BufferedReader(readerTarget);
        List <String> targetList = new ArrayList<>();
        while (bufferedReaderTarget.ready()) {
            String tempTarget = bufferedReaderTarget.readLine();
            targetList.add(tempTarget);
//            System.out.println(tempTarget);
        }
        bufferedReaderTarget.close();
        int i = 0;
        while (i <= sourceList.size()) {
            if (i == sourceList.size() && i == targetList.size()) {
                break;
            }
            if ((i == sourceList.size() - 1) && i == targetList.size()) {
//                targetList.add("");
                lines.add(new LineItem(Type.REMOVED, sourceList.get(i)));
                break;
            }
            if (i == sourceList.size() && (i == targetList.size() - 1)) {
                lines.add(new LineItem(Type.ADDED, targetList.get(i)));
                break;
            }
            if (sourceList.get(i).equals(targetList.get(i))) {
                lines.add(new LineItem(Type.SAME, sourceList.get(i)));
            }
            if (!sourceList.get(i).equals(targetList.get(i)) && sourceList.get(i).equals(targetList.get(i + 1))) {
                sourceList.add(i, targetList.get(i));
                lines.add(new LineItem(Type.ADDED, targetList.get(i)));
            }
            if (!sourceList.get(i).equals(targetList.get(i)) && targetList.get(i).equals(sourceList.get(i + 1))) {
                targetList.add(i, sourceList.get(i));
                lines.add(new LineItem(Type.REMOVED, sourceList.get(i)));
            }
            i++;
        }

//        for (int j = 0; j < lines.size(); j++) {
//            System.out.println(lines.get(j).type + " " + lines.get(j).line);
//        }



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

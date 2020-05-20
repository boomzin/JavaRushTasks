package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> foundWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < crossword.length; j++) {
                for (int k = 0; k < crossword[0].length; k++) {
                    if (words[i].substring(0, 1).equals(String.valueOf((char) crossword[j][k]))) {
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                String tmp = "";
                                for (int l = 0; l < words[i].length(); l++) {
                                    try {
                                        tmp += String.valueOf((char) crossword[j + l * y][k + l * x]);
                                    } catch (IndexOutOfBoundsException e) {
//                                        System.out.println(words[i] + " " + (char) crossword[j][k] + " " + tmp);
                                    }
                                }
                                if (words[i].equals(tmp)) {
                                    Word word = new Word(tmp);
                                    word.setStartPoint(k , j );
                                    word.setEndPoint(k + (tmp.length() - 1) * x, j + (tmp.length() - 1) * y);
                                    foundWords.add(word);
                                }
                            }
                        }
                    }
                }
            }
        }
        return foundWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

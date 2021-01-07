package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/


import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(maxSquare(new int[][]{{1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                                 {1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                                                 {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0},
                                                 {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
                                                 {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                                                 {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                                 {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}}));
        Date finish = new Date();
        System.out.println(finish.getTime() - start.getTime());
        System.out.println(maxSquare(new int[10000][10000]));
    }

    public static int maxSquare(int[][] matrix) {
        int maxSquare = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int squareSide = 1;
                    for (int k = i; k < matrix.length; k++) {
                        if (matrix[k][j] == 0) {
                            break;
                        }
                        if (j + squareSide <= matrix[0].length) {
                            int square =0;
                            for (int l = 0; l < squareSide; l++) {
                                for (int m = 0; m < squareSide; m++) {
                                    if (matrix[i + l][j + m] == 0) {
                                        break;
                                    }
                                    square += matrix[i + l][j + m];
                                }
                                if (matrix[i + l][j] == 0) {
                                    break;
                                }
                            }
                            if (square == squareSide * squareSide) {
                                if (square > maxSquare) {
                                    maxSquare = square;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                        squareSide ++;
                    }
                }
            }
        }
        return maxSquare;
    }
}

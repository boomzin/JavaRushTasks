package com.javarush.task.task39.task3905;

//import java.util.Random;

/* 
Залей меня полностью
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][]{{Color.BLUE, Color.RED, Color.ORANGE},
                                        {Color.BLUE, Color.GREEN, Color.ORANGE},
                                        {Color.BLUE, Color.GREEN, Color.ORANGE},
                                        {Color.BLUE, Color.GREEN, Color.ORANGE},
                                        {Color.BLUE, Color.RED, Color.ORANGE},
                                        {Color.BLUE, Color.GREEN, Color.ORANGE}};
        PhotoPaint photoPaint = new PhotoPaint();
        System.out.println(photoPaint.paintFill(image, 0, 2, Color.INDIGO));
        System.out.println(Arrays.deepToString(image));

    }
}

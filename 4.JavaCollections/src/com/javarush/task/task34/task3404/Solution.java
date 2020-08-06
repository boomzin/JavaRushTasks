package com.javarush.task.task34.task3404;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        String s;
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5 + 1.5*4) +28)", 0); //expected output 0.5 6
//        System.out.println(4/2);
//        s = "sin(2*(-5+ 1.5*4)+28)";
//        System.out.print(s + " expected output 0.5 6 actually ");
//        solution.recurse(s, 0);
//        s = "tan(45)";
//        System.out.print(s + " expected output 1 1 actually ");
//        solution.recurse(s, 0);
//        s = "tan(-45)";
//        System.out.print(s + " expected output -1 2 actually ");
//        solution.recurse(s, 0);
        s = "-0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recurse(s, 0);
        s = "-0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recurse(s, 0);
        s = "(-0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recurse(s, 0);
//        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
//        System.out.print(s + " expected output 12 8 actually ");
//        solution.recurse(s, 0);
//        s = "tan(44+sin(89-cos(180)^2))";
//        System.out.print(s + " expected output 1 6 actually ");
//        solution.recurse(s, 0);
//        s = "-2+(-2+(-2)-2*(2+2))";
//        System.out.print(s + " expected output -14 8 actually ");
//        solution.recurse(s, 0);
//        s = "sin(80+(2+(1+1))*(1+1)+2)";
//        System.out.print(s + " expected output 1 7 actually ");
//        solution.recurse(s, 0);
//        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
//        System.out.print(s + " expected output 6 11 actually ");
//        solution.recurse(s, 0);
    }

    public void recurse(final String expression, int countOperation) {
        String clearExpression = expression.replaceAll(" ", "");
        List<String> regExp = new ArrayList<>();
        regExp.add("[^ns]\\(-?[0-9]+\\.?[0-9]+\\)|^\\(-?[0-9]+\\.?[0-9]+\\)");//Remove brackets
        regExp.add("^\\(?-?[0-9]*.?[0-9]*\\)?$");//The result is ready
        regExp.add("[0-9]*.?[0-9]*\\^[*0-9].?[*0-9]*");//Power is ready to be calculated
        regExp.add("cos\\([0-9]*\\.?[0-9]*\\)");//Cos is ready to be calculated
        regExp.add("sin\\([0-9]*\\.?[0-9]*\\)");//Sin is ready to be calculated
        regExp.add("tan\\([0-9]*\\.?[0-9]*\\)");//Tan is ready to be calculated
        regExp.add("[0-9]*\\.?[0-9]*\\*[0-9]+\\.?[0-9]*");//Multiply is ready to be calculated
        regExp.add("[0-9]+\\.?[0-9]*\\/[0-9]+\\.?[0-9]*");//Division is ready to be calculated
        regExp.add("[0-9]+\\.?[0-9]*\\+[0-9]+\\.?[0-9]*");//Addition is ready to be calculated
        regExp.add("\\-?[0-9]+\\.?[0-9]*\\-[0-9]+\\.?[0-9]*");//Subtraction is ready to be calculated
        if (countOperation == 0) {
            Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|cos|sin|tan|\\^");
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
                countOperation ++;
            }
        }
        for (int i = 0; i < regExp.size(); i++) {
            Pattern pattern = Pattern.compile(regExp.get(i));
            Matcher matcher = pattern.matcher(clearExpression);
            while (matcher.find()){
                switch (i) {
                    case 0:
                    case 1:
                }
            }
        }
        return;
    }

    public Solution() {
        //don't delete
    }
}

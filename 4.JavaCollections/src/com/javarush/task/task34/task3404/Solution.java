package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
//        solution.recurse("sin(2*(-5 + 1.5*4) +28)", 0); //expected output 0.5 6
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
//        s = "5 + (-5)+ cos(-5)";
//        String s1 = "(-5)";
//        System.out.println(s1);
//        System.out.println(s1.substring(1, s1.length() - 1));
//        String s3 = s.replaceFirst(Pattern.quote(s1), s1.substring(1, s1.length() - 1));
//        System.out.println(s3);
//        System.out.print(s + " expected output 0.3 0 actually ");
//        solution.recurse(s, 0);
//        s = "0.305";
//        System.out.print(s + " expected output 0.3 0 actually ");
//        solution.recurse(s, 0);
//        s = "0.3051";
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recurse(s, 0);
//        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
//        System.out.print(s + " expected output 12 8 actually ");
//        solution.recurse(s, 0);
        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recurse(s, 0);
//        s = "-2+(-2+(-2)-2*(2+2))";
//        System.out.print(s + " expected output -14 8 actually ");
//        solution.recurse(s, 0);
//        s = "sin(80+(2+(1+1))*(1+1)+2)";
//        System.out.print(s + " expected output 1 7 actually ");
//        solution.recurse(s, 0);
//        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
//        System.out.print(s + " expected output 6 11 actually ");
//        solution.recurse(s, 0);
//        s = "2+2+2-4";
//        System.out.println(Math.cos(Math.toRadians(60)));
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recurse(s, 0);


    }

    public void recurse(final String expression, int countOperation) {
        Double firstArg = 0.0;
        Double secondArg = 0.0;
        Double result = 0.0;
        String func = "";
        String clearExpression = expression.replaceAll(" ", "");
        clearExpression = clearExpression.replaceAll("--", "+");
        clearExpression = clearExpression.replaceAll("\\+-", "-");
        List<String> regExp = new ArrayList<>();
        regExp.add("\\(-?[0-9]+\\.?[0-9]*\\)(?![\\^\\*\\/])");//Remove brackets
        regExp.add("^[-\\+]?[0-9]+\\.?[0-9]*$");//The result is ready
        regExp.add("(cos|sin|tan)-?[0-9]+\\.?[0-9]*");//Cos|sin|tan is ready to be calculated
        regExp.add("[0-9]+\\.?[0-9]*\\^\\-?[*0-9]+\\.?[*0-9]*|\\(\\-?[0-9]+\\.?[0-9]*\\)\\^\\-?[*0-9]+\\.?[*0-9]*");//Power is ready to be calculated
        regExp.add("[0-9]+\\.?[0-9]*[\\*\\/]\\-?[0-9]+\\.?[0-9]*|\\(\\-?[0-9]+\\.?[0-9]*\\)[\\*\\/]\\-?[0-9]+\\.?[0-9]*");//Multiply|Division is ready to be calculated
        regExp.add("\\-?[0-9]+\\.?[0-9]*[\\+\\-][0-9]+\\.?[0-9]*(?![\\^\\*\\/])");//Addition|Subtraction is ready to be calculated
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
                        clearExpression = matcher.replaceFirst(matcher.group().substring(1, matcher.group(0).length() -1));
                        recurse(clearExpression, countOperation);
                        return;

                    case 1:
                        BigDecimal bigDecimal= new BigDecimal(matcher.group(0));
                        System.out.println(new DecimalFormat("#.##").format(bigDecimal.setScale(2, BigDecimal.ROUND_CEILING).doubleValue()) + " " + countOperation);
                        return;
                    case 2:
                        func = matcher.group(0).substring(0, 3);
                        switch (func) {
                            case "sin":
                                firstArg = Math.sin(Math.toRadians(new Double(matcher.group(0).substring(3))));
                                break;
                            case "cos":
                                firstArg = Math.cos(Math.toRadians(new Double(matcher.group(0).substring(3))));
                                break;
                            case "tan":
                                firstArg = Math.tan(Math.toRadians(new Double(matcher.group(0).substring(3))));
                                break;
                        }
                        clearExpression = matcher.replaceFirst(new DecimalFormat("#.########").format(firstArg));
                        recurse(clearExpression, countOperation);
                        return;
                    case 3:
                        if (matcher.group(0).contains("(")) {
                            firstArg = new Double(matcher.group(0).substring(1, matcher.group(0).indexOf(")")));
                        } else {
                            firstArg = new Double(matcher.group(0).substring(0, matcher.group(0).indexOf("^")));
                        }
                        secondArg = new Double(matcher.group(0).substring(matcher.group(0).indexOf("^") + 1));
                        result = Math.pow(firstArg, secondArg);
                        clearExpression = matcher.replaceFirst(new DecimalFormat("#.########").format(result));
                        recurse(clearExpression, countOperation);
                        return;
                    case 4:
                        if (matcher.group(0).contains("(")) {
                            firstArg = new Double(matcher.group(0).substring(1, matcher.group(0).indexOf(")")));
                            func = matcher.group(0).substring(matcher.group(0).indexOf(")") + 1, matcher.group(0).indexOf(")") + 2);
                        } else {
                            if (matcher.group(0).contains("*")){
                                func = "*";
                                firstArg = new Double(matcher.group(0).substring(0, matcher.group(0).indexOf("*")));
                                result = firstArg * secondArg;
                            } else {
                                func = "/";
                                firstArg = new Double(matcher.group(0).substring(0, matcher.group(0).indexOf("/")));
                            }
                        }
                        secondArg = new Double(matcher.group(0).substring(matcher.group(0).indexOf(func) + 1));
                        switch (func) {
                            case "*":
                                result = firstArg * secondArg;
                                break;
                            case "/":
                                result = firstArg / secondArg;
                                break;
                        }
                        clearExpression = matcher.replaceFirst(new DecimalFormat("#.########").format(result));
                        recurse(clearExpression, countOperation);
                        return;
                    case 5:
                        if (matcher.group(0).contains("+")){
                            firstArg = new Double(matcher.group(0).substring(0, matcher.group(0).indexOf("+")));
                            secondArg = new Double(matcher.group(0).substring(matcher.group(0).indexOf("+") + 1));
                            result = firstArg + secondArg;
                        } else {
                            firstArg = new Double(matcher.group(0).substring(0, matcher.group(0).lastIndexOf("-")));
                            secondArg = new Double(matcher.group(0).substring(matcher.group(0).lastIndexOf("-") + 1));
                            result = firstArg - secondArg;
                        }
                        clearExpression = matcher.replaceFirst(new DecimalFormat("#.########").format(result));
                        recurse(clearExpression, countOperation);
                        return;
                }
            }
        }
        return;
    }

    public Solution() {
        //don't delete
    }
}

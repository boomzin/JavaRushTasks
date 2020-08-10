package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        String s;
        Solution solution = new Solution();
//        s ="sin(2*(-5+1.5*4)+28)";
//        System.out.print(s + " expected output 0.5 6 actually ");
//        solution.recurse(s, 0);
//        s = "tan(45)";
//        System.out.print(s + " expected output 1 1 actually ");
//        solution.recurse(s, 0);
//        s = "tan(-45)";
//        System.out.print(s + " expected output -1 2 actually ");
//        solution.recurse(s, 0);
//        s = "0.305";
//        System.out.print(s + " expected output 0.3 0 actually ");
//        solution.recurse(s, 0);
//        s = "0.3051";
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recurse(s, 0);
//        s = "(0.3051)";
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recurse(s, 0);
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
//        s = "10-2^(2-1+1)";
//        System.out.print(s + " expected output 6 4 actually ");
//        solution.recurse(s, 0);
//        s = "2^10+2^(5+5)";
//        System.out.print(s + " expected output 2048 4 actually ");
//        solution.recurse(s, 0);
//        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
//        System.out.print(s + " expected output 72.96 8 actually ");
//        solution.recurse(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recurse(s, 0);
//        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
//        System.out.print(s + " expected output -3 16 actually ");
//        solution.recurse(s, 0);
//        s = "cos(3 + 19*3)";
//        System.out.print(s + " expected output 0.5 3 actually ");
//        solution.recurse(s, 0);
//        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
//        System.out.print(s + " expected output 8302231.36 14 actually ");
//        solution.recurse(s, 0);
//        s = "(-1 + (-2))";
//        System.out.print(s + " expected output -3 3 actually ");
//        solution.recurse(s, 0);
//        s = "-sin(2*(-5+1.5*4)+28)";
//        System.out.print(s + " expected output -0.5 7 actually ");
//        solution.recurse(s, 0);
//        s = "sin(100)-sin(100)";
//        System.out.print(s + " expected output 0 3 actually ");
//        solution.recurse(s, 0);
//        s = "-(-22+22*2)";
//        System.out.print(s + " expected output -22 4 actually ");
//        solution.recurse(s, 0);
//        s = "-2^(-2)";
//        System.out.print(s + " expected output -0.25 3 actually ");
//        solution.recurse(s, 0);
//        s = "-(-2^(-2))+2+(-(-2^(-2)))";
//        System.out.print(s + " expected output 2.5 10 actually ");
//        solution.recurse(s, 0);
//        s = "(-2)*(-2)";
//        System.out.print(s + " expected output 4 3 actually ");
//        solution.recurse(s, 0);
//        s = "(-2)/(-2)";
//        System.out.print(s + " expected output 1 3 actually ");
//        solution.recurse(s, 0);
//        s = "sin(-30)";
//        System.out.print(s + " expected output -0.5 2 actually ");
//        solution.recurse(s, 0);
//        s = "cos(-30)";
//        System.out.print(s + " expected output 0.87 2 actually ");
//        solution.recurse(s, 0);
//        s = "tan(-30)";
//        System.out.print(s + " expected output -0.58 2 actually ");
//        solution.recurse(s, 0);
//        s = "2+8*(9/4-1.5)^(1+1)";
//        System.out.print(s + " expected output 6.5 6 actually ");
//        solution.recurse(s, 0);
//        s = "0.005 ";
//        System.out.print(s + " expected output 0.01 0 actually ");
//        solution.recurse(s, 0);
//        s = "0.0049 ";
//        System.out.print(s + " expected output 0 0 actually ");
//        solution.recurse(s, 0);
//        s = "0+0.304";
//        System.out.print(s + " expected output 0.3 1 actually ");
//        solution.recurse(s, 0);
//        s = "-0";
//        System.out.print(s + " expected output 0 1 actually ");
//        solution.recurse(s, 0);

    }

    public void recurse(final String expression, int countOperation) {
        Locale.setDefault(Locale.ENGLISH);
        Double firstArg = 0.0;
        Double secondArg = 0.0;
        Double result = 0.0;
        String func = "";
        String clearExpression = expression.replaceAll(" +", "");
        clearExpression = clearExpression.replaceAll("--", "+");
        clearExpression = clearExpression.replaceAll("\\+-", "-");
        clearExpression = clearExpression.replaceAll("\\+\\+", "+");
        List<String> regExp = new ArrayList<>();
        regExp.add("\\([\\-\\+]?[0-9]+\\.?[0-9]*\\)(?![\\^\\*\\/])");//Remove brackets
        regExp.add("^[-\\+]?[0-9]+\\.?[0-9]*$");//The result is ready
        regExp.add("(cos|sin|tan)-?[0-9]+\\.?[0-9]*");//Cos|sin|tan is ready to be calculated
        regExp.add("[0-9]+\\.?[0-9]*\\^\\-?[0-9]+\\.?[0-9]*|\\(\\-?[0-9]+\\.?[0-9]*\\)\\^\\-?[*0-9]+\\.?[*0-9]*");//Power is ready to be calculated
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
                        clearExpression = matcher.replaceFirst(matcher.group().substring(1, matcher.group().length() -1));
                        recurse(clearExpression, countOperation);
                        return;

                    case 1:
                        NumberFormat nf = new DecimalFormat("#.##");
                        Double finish = Double.parseDouble(matcher.group());
                        System.out.println(String.format("%s %d", nf.format(finish),countOperation).replace(",","."));

//                        BigDecimal bigDecimal= new BigDecimal(matcher.group());
//                        System.out.println(new DecimalFormat("#.##").format(bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue()) + " " + countOperation);
                        break;
                    case 2:
                        func = matcher.group().substring(0, 3);
                        switch (func) {
                            case "sin":
                                result = Math.sin(Math.toRadians(new Double(matcher.group().substring(3))));
                                break;
                            case "cos":
                                result = Math.cos(Math.toRadians(new Double(matcher.group().substring(3))));
                                break;
                            case "tan":
                                result = Math.tan(Math.toRadians(new Double(matcher.group().substring(3))));
                                break;
                        }
                        clearExpression = matcher.replaceFirst(String.format("%f", result));
                        recurse(clearExpression, countOperation);
                        return;
                    case 3:
                        if (matcher.group().contains("(")) {
                            firstArg = new Double(matcher.group().substring(1, matcher.group().indexOf(")")));
                        } else {
                            firstArg = new Double(matcher.group().substring(0, matcher.group().indexOf("^")));
                        }
                        secondArg = new Double(matcher.group().substring(matcher.group().indexOf("^") + 1));
                        result = Math.pow(firstArg, secondArg);
                        clearExpression = matcher.replaceFirst(String.format("%f", result));
                        recurse(clearExpression, countOperation);
                        return;
                    case 4:
                        if (matcher.group().contains("(")) {
                            firstArg = new Double(matcher.group().substring(1, matcher.group().indexOf(")")));
                            func = matcher.group().substring(matcher.group().indexOf(")") + 1, matcher.group().indexOf(")") + 2);
                        } else {
                            if (matcher.group().contains("*")){
                                func = "*";
                                firstArg = new Double(matcher.group().substring(0, matcher.group().indexOf("*")));
                            } else {
                                func = "/";
                                firstArg = new Double(matcher.group().substring(0, matcher.group().indexOf("/")));
                            }
                        }
                        secondArg = new Double(matcher.group().substring(matcher.group().indexOf(func) + 1));
                        switch (func) {
                            case "*":
                                result = firstArg * secondArg;
                                break;
                            case "/":
                                result = firstArg / secondArg;
                                break;
                        }
                        clearExpression = matcher.replaceFirst(String.format("%f", result));
                        recurse(clearExpression, countOperation);
                        return;
                    case 5:
                        if (matcher.group().contains("+")){
                            firstArg = new Double(matcher.group().substring(0, matcher.group().indexOf("+")));
                            secondArg = new Double(matcher.group().substring(matcher.group().indexOf("+") + 1));
                            result = firstArg + secondArg;
                        } else {
                            firstArg = new Double(matcher.group().substring(0, matcher.group().lastIndexOf("-")));
                            secondArg = new Double(matcher.group().substring(matcher.group().lastIndexOf("-") + 1));
                            result = firstArg - secondArg;
                        }
                        clearExpression = matcher.replaceFirst(String.format("%f", result));
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

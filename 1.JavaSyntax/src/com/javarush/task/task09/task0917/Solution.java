package com.javarush.task.task09.task0917;

/* 
Перехват unchecked-исключений
*/

public class Solution {
    public static void main(String[] args) {
        handleExceptions(new Solution());
    }

    public static void handleExceptions(Solution obj) {
        for (int i = 1; i <= 3; i++) {
            try {
                if (i==1){
                    obj.method1();
                }
                else if (i==2){
                    obj.method2();
                }
                else if (i==3){
                    obj.method3();
                }
            }
            catch (RuntimeException e){
                printStack(e);

            }
        }
    }

    public static void printStack(Throwable throwable) {
        System.out.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }
    }

    public void method1() {
        throw new NullPointerException();
    }

    public void method2() {
        throw new IndexOutOfBoundsException();
    }

    public void method3() {
        throw new NumberFormatException();
    }
}


package com.javarush.task.task09.task0916;

import java.io.IOException;
import java.rmi.RemoteException;

/* 
Перехват checked-исключений
*/

public class Solution {
//    private static Exception exception = null;
    public static void main(String[] args) {
            handleExceptions(new Solution());

    }

    public static void handleExceptions (Solution obj) {
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
            catch (Exception e){
                System.out.println(e);

                }
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}

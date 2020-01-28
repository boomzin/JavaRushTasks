package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new Infinity()));
        threads.add(new Thread(new InterruptedThread()));
        threads.add(new Thread(new Hurray()));
        threads.add(new WarningMessage());
        threads.add(new Thread(new NumberSum()));
    }

    public static void main(String[] args) {
//        threads.get(4).start();
    }

    public static class Infinity implements Runnable {
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class InterruptedThread implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Hurray implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class WarningMessage extends Thread implements Message{
        private boolean isLive = true;

        @Override
        public void showWarning() {
            isLive = false;
        }

        @Override
        public void run() {
            while (isLive){
            }
        }
    }

    public static class NumberSum implements Runnable{
        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String numbers = "0";
            int sum = 0;
            try {
                while ((numbers = bufferedReader.readLine()) != "N"){
                    sum = sum + Integer.parseInt(numbers);
                }
                System.out.println(sum);
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(sum);
            }
        }
    }


}
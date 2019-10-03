package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int left;
    int top;
    int height;
    int width;

    public void initialize (int left,int top){
        this.left=left;
        this.top=top;
        this.height=0;
        this.width=0;
    }
    public void initialize (int left,int top, int height,int width){
        this.left=left;
        this.top=top;
        this.height=height;
        this.width=width;
    }
    public void initialize (int left,int top, int width){
        this.left=left;
        this.top=top;
        this.height=width;
        this.width=width;
    }
    public void initialize (Rectangle rectangle){
        this.width=rectangle.width;
        this.height=rectangle.height;
        this.top=rectangle.top;
        this.left=rectangle.left;
    }



    //напишите тут ваш код

    public static void main(String[] args) {

    }
}

package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human son1=new Human("son1",true,3,new ArrayList());
        Human son2=new Human("son2",true,5,new ArrayList());
        Human doughter1=new Human("doughter1",false,7,new ArrayList());
        Human mother=new Human("mother",false,30,new ArrayList(Arrays.asList(son1,son2,doughter1)));
        Human father=new Human("father",true,40,new ArrayList(Arrays.asList(son1,son2,doughter1)));
        Human ded1=new Human("ded1",true,71,new ArrayList(Arrays.asList(father)));
        Human ded2=new Human("ded2",true,72,new ArrayList(Arrays.asList(mother)));
        Human grandma1=new Human("grandma1",false,61,new ArrayList(Arrays.asList(father)));
        Human grandma2=new Human("grandma2",false,62,new ArrayList(Arrays.asList(mother)));
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(doughter1);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(grandma1);
        System.out.println(grandma2);
        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name,boolean sex,int age,ArrayList children){
            this.name=name;
            this.sex=sex;
            this.children=children;
            this.age=age;
        }
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

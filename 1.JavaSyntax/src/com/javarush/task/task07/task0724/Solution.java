package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human ded1= new Human("ded1",true,199);
        Human ded2= new Human("ded2",true,109);
        Human babka= new Human("babka1",false,188);
        Human babka2 = new Human("babka2",false,108);
        Human father= new Human("father",true,108,ded1,babka);
        Human mother= new Human("mother",false,108,ded2,babka2);
        Human son1= new Human("son1",true,20,father,mother);
        Human son2= new Human("son2",true,5,father,mother);
        Human son3= new Human("son3",true,1,father,mother);

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(babka.toString());
        System.out.println(babka2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
        // напишите тут ваш код
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
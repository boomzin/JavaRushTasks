package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {

//        return(this.weight+this.strength+this.age>anotherCat.age+anotherCat.strength+anotherCat.weight);

//        int cat1power;
//        int cat2power;
//        cat1power= this.strength+this.weight+this.age;
//        cat2power= anotherCat.strength+anotherCat.weight+anotherCat.age;
//        if (cat1power>cat2power){
//            return true;
//        }
//        else {
//            return false;
//        }
        int cat1power=0;
        int cat2power=0;


        if (this.age>anotherCat.age){
            cat1power++;
        }
        else if (this.age==anotherCat.age){
            cat1power++;
            cat2power++;
        }
        else {
            cat2power++;
        }
        if (this.weight>anotherCat.weight){
            cat1power++;
        }
        else if (this.weight==anotherCat.weight){
            cat1power++;
            cat2power++;
        }
        else{
            cat2power++;
        }
        if (this.strength>anotherCat.strength){
            cat1power++;
        }
        else if (this.strength==anotherCat.strength){
            cat1power++;
            cat2power++;
        }
        else{
            cat2power++;
        }
        if (cat1power>cat2power){
            return true;
        }
        else {
            return false;
        }
        //return cat1power>cat2power;
//        int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
//        int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
//        int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;
//
//        int score = ageAdvantage + weightAdvantage + strengthAdvantage;
//        return score > 2; // return score > 2 ? true : false;
//        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}

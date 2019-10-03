package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfaName = reader.readLine();
        Cat catGrandFa = new Cat(grandfaName);

        String grandmaName = reader.readLine();
        Cat catGrandMa = new Cat(grandmaName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGrandFa, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGrandMa);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName,catFather,catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName,catFather, catMother);

        System.out.println(catGrandFa);
        System.out.println(catGrandMa);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentM;
        private Cat parentF;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentM, Cat parentF) {
            this.name = name;
            this.parentM = parentM;
            this.parentF = parentF;
        }

        @Override
        public String toString() {
            if (parentF == null&&parentM ==null) {
                return "The cat's name is " + name + ", no mother " + ", no father";
            }
            else if (parentF !=null&&parentM ==null) {
                return "The cat's name is " + name + ", mother is " + parentF.name + ", no father";
            }
            else if (parentF ==null&&parentM !=null) {
                return "The cat's name is " + name + ", no mother, father is " + parentM.name;
            }
            else {
                return "The cat's name is " + name + ", mother is " + parentF.name + ", father is " + parentM.name;
            }
        }
    }

}

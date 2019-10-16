package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

import java.util.HashMap;

public class Solution {
//    static HashMap<String,String> map= new HashMap<>();
    public static void main(String[] args) {
//        map.put("Cat","Кот");
//        map.put("Tiger","Тигр");
//        map.put("Lion","Лев");
//        map.put("Bull","Бык");
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
//        String classname=o.getClass().getSimpleName();
//        if (map.containsKey(classname)){
////            String endname=map.get(classname);
//            return (String) map.get(classname);
//        }
        if (o.getClass().getSimpleName().equals("Cat")){
            return "Кот";
        }
        if (o.getClass().getSimpleName().equals("Tiger")){
            return "Тигр";
        }
        if (o.getClass().getSimpleName().equals("Lion")){
            return "Лев";
        }
        if (o.getClass().getSimpleName().equals("Bull")){
            return "Бык";
        }

        //напишите тут ваш код

        return "Животное";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}

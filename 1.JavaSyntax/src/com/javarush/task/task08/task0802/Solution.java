package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String,String> pair= new HashMap<String, String>();
        pair.put("арбуз","ягода");
        pair.put("банан","трава");
        pair.put("вишня","ягода");
        pair.put("груша","фрукт");
        pair.put("дыня","овощ");
        pair.put("ежевика","куст");
        pair.put("жень-шень","корень");
        pair.put("земляника","ягода");
        pair.put("ирис","цветок");
        pair.put("картофель","клубень");
        for (Map.Entry<String, String> entry : pair.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        //напишите тут ваш код

    }
}

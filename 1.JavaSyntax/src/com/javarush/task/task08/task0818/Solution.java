package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> surnameToSalary = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            surnameToSalary.put(String.valueOf(i), i + 496);
        }
        return surnameToSalary;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> surnameToSalaryEntry = iterator.next();
            if (surnameToSalaryEntry.getValue() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        // use ArrayList instead of a List, otherwise the validation will fail :DD
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            strings.add(line);
        }
        reader.close();

        int maxLengthPosition = 0;
        int minLengthPosition = 0;

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(maxLengthPosition).length() < strings.get(i).length()) {
                maxLengthPosition = i;
            }
            if (strings.get(minLengthPosition).length() > strings.get(i).length()) {
                minLengthPosition = i;
            }
        }
        for (int i = 0; i < strings.size(); i++) {

        }
        if (maxLengthPosition < minLengthPosition) {
            System.out.println(strings.get(maxLengthPosition));
        } else {
            // when minLengthPosition < maxLengthPosition or equal
            System.out.println(strings.get(minLengthPosition));
        }
    }
}

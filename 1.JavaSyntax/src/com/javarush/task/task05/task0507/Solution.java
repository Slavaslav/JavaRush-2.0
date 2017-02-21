package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine();
                int number;
                try {
                    number = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    continue;
                }
                if (number == -1) {
                    break;
                }
                integers.add(number);
            }
        }
        float sum = 0;
        for (int number : integers) {
            sum += number;
        }
        float average = sum / integers.size();
        System.out.println(average);
    }
}


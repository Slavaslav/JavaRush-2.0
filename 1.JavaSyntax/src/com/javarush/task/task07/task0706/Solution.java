package com.javarush.task.task07.task0706;

/*
Улицы и дома
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] ints = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ints.length; i++) {
            String line = reader.readLine();
            int number = Integer.parseInt(line);
            ints[i] = number;
        }
        reader.close();
        int residentsInOdd = 0;
        int residentsInEven = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i % 2 == 0) {
                residentsInEven += ints[i];
            } else {
                residentsInOdd += ints[i];
            }
        }
        if (residentsInEven > residentsInOdd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}

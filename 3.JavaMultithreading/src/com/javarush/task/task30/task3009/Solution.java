package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    private static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};

    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 2; i < 37; i++) {
            int intNumber;
            try {
                intNumber = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                continue;
            }
            // convert number to specified radix
            StringBuilder stringBuilder = new StringBuilder();
            while (intNumber != 0) {
                int remainder = intNumber % i;
                if (remainder < 10) {
                    stringBuilder.insert(0, remainder);
                } else {
                    stringBuilder.insert(0, alphabet[remainder - 10]);
                }
                intNumber = intNumber / i;
            }
            // is palindrome?
            if (stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
                integers.add(i);
            }
        }
        return integers;
    }
}
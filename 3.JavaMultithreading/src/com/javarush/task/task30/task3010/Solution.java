package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int minRadix = 0;
        for (int i = 2; i < 37; i++) {
            try {
                new BigDecimal(new BigInteger(args[0], i));
                minRadix = i;
                break;
            } catch (Exception e) {

            }
        }
        System.out.print(minRadix > 0 ? minRadix : "incorrect");
    }
}
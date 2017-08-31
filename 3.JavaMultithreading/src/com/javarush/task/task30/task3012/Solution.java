package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder result = new StringBuilder(number + " =");
        int basis = 3;
        for (int i = 0; ; i++) {
            int remainder = number % basis;
            number = number / basis;

            if (remainder > 0) {
                String sign = null;
                if (remainder == 1) {
                    sign = "+";
                } else if (remainder == 2) {
                    sign = "-";
                    number++;
                }
                String sNumber = String.format(" %s %d", sign, ((int) Math.pow(basis, i)));
                result.append(sNumber);
            }

            if (number < basis) {
                i++;
                if (number > 0) {
                    String sNumber = null;
                    if (number == 2) {
                        sNumber = String.format(" - %d + %d", ((int) Math.pow(basis, i)), ((int) Math.pow(basis, ++i)));
                    } else if (number == 1) {
                        sNumber = String.format(" + %d", ((int) Math.pow(basis, i)));
                    }
                    result.append(sNumber);
                }
                break;
            }
        }
        System.out.print(result.toString());
    }
}
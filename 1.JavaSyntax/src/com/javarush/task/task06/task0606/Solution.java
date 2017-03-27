package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();
        int number = Integer.parseInt(line);

        while (number != 0) {
            int remainder = number % 10;
            if (remainder % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            number = number / 10;
        }
        System.out.println(String.format("Even: %d Odd: %d", even, odd));
    }
}

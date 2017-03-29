package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();

        int maxSequenceLength = 0;
        for (int i = 0; i < integers.size(); i++) {
            int number = integers.get(i);
            int sequenceLength = 0;
            for (int j = i; j < integers.size(); j++) {
                int nextNumber = integers.get(j);
                if (number == nextNumber) {
                    sequenceLength++;
                } else {
                    i = j - 1;
                    break;
                }
            }
            if (sequenceLength > maxSequenceLength) {
                maxSequenceLength = sequenceLength;
            }
        }
        System.out.println(maxSequenceLength);
    }
}
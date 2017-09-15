package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        /*args = new String[3];
        args[0] = "G:\\1.txt";
        args[1] = "1";
        args[2] = "text";*/

        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(Integer.parseInt(args[1]));
        byte[] bytes = new byte[args[2].length()];
        randomAccessFile.read(bytes, 0, args[2].length());

        String stringFromFile = convertByteToString(bytes);

        randomAccessFile.seek(randomAccessFile.length());
        if (stringFromFile.equals(args[2])) {
            randomAccessFile.write("true".getBytes());
        } else {
            randomAccessFile.write("false".getBytes());
        }
        randomAccessFile.close();
    }

    private static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
package com.company;
import java.io.*;
import java.util.*;


public class Lab5Main {
    public static void main(String args[]) throws IOException{



        String fileName1 ="file1.txt";
        String fileName2 ="file2.txt";

        byte[] bytesToWrite = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        byte[] bytesReaded =new byte[20];



        try {
            long  timeStart =System.currentTimeMillis();
            FileOutputStream outFile = new FileOutputStream(fileName1);
            outFile.write(bytesToWrite); //запись в файл
            outFile.close();
            long  timeFinish =System.currentTimeMillis();
            System.out.println("Время записи: " +(timeFinish - timeStart));

            timeStart =System.currentTimeMillis();
            FileInputStream inFile =new FileInputStream(fileName1);
            int bytesAvailable =inFile.available(); //сколько можно считать
            int count =inFile.read(bytesReaded,0,bytesAvailable);
            inFile.close();
            timeFinish =System.currentTimeMillis();
            System.out.println("Время чтения: " +(timeFinish - timeStart));
        }

        catch (FileNotFoundException e){
            System.out.println("Невозможно произвести запись в файл:"+fileName1);}

    }
}

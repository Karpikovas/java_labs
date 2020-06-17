package com.company;
import java.io.*;
import java.util.*;


public class Lab5Main2 {
    public static void main(String args[]) throws IOException{

        String fileName2 ="file2.txt";
        InputStream inStream =null;
        OutputStream outStream =null;

        byte[] bytesToWrite = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try {
            long  timeStart =System.currentTimeMillis();
            outStream =new FileOutputStream(fileName2);
            outStream =new BufferedOutputStream(outStream);
            outStream.write(bytesToWrite); //запись в файл
            outStream.close();
            long  timeFinish =System.currentTimeMillis();
            System.out.println("Время записи: " +(timeFinish - timeStart));

            timeStart =System.currentTimeMillis();
            inStream =new FileInputStream(fileName2);
            inStream =new BufferedInputStream(inStream);
            while(inStream.read()!=-1);
            inStream.close();
            timeFinish =System.currentTimeMillis();
            System.out.println("Время чтения: " +(timeFinish - timeStart));

        }

        catch (FileNotFoundException e){
            System.out.println("Невозможно произвести запись в файл:"+fileName2);}

    }
}
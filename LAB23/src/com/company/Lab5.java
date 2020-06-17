package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class Lab5 extends Lab4Aplet {

    @Override
    public void init() {
        super.init();
        Button loadFromFile = new Button("Load from file");
        Button saveToFile = new Button("Save to file");
        this.add(loadFromFile);
        this.add(saveToFile);

        saveToFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String myFile = "C:\\Users\\user\\Desktop\\JAVA\\LAB23\\file3.txt";
                    FileOutputStream outFile = new FileOutputStream(myFile);
                    ObjectOutputStream oos = new ObjectOutputStream(outFile);
                    oos.writeObject(rects);
                    oos.close();
                }

                catch (FileNotFoundException exc) {
                    System.out.println("File not found");
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                    System.out.println("IO error");
                }

            }
        });
        loadFromFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String myFile = "C:\\Users\\user\\Desktop\\JAVA\\LAB23\\file3.txt";
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
                    rects = (ArrayList<Rectangle>)ois.readObject();
                    ois.close();
                    repaint();
                }
                catch(IOException i){
                    System.out.println("Ошибка");
                }
                catch (ClassNotFoundException pass) {}
            }

        });

    }
}

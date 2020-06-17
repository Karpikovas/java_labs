package com.company;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io. *;
import java.util.*;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


public class Lab5Aplet extends Applet {
    ArrayList<Rectangle> rects = new ArrayList<>();
    int last_x, last_y;

    Button r = new Button("Rect");
    Button cr = new Button("ColoredRect");
    Button dr = new Button("DrawableRect");
    Button loadFromFile = new Button("Load from file");
    Button saveToFile = new Button("Save to file");

    public void init(){
        r.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final Random random = new Random();
                int num = random.nextInt(200);
                Rectangle rect = new Rectangle(num, num, num + 50, num + 50);
                Graphics g = getGraphics();
                rect.draw(g);
                rects.add(rect);
            }
        });

        dr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final Random random = new Random();
                int num = random.nextInt(200);
                DrawableRect rect = new DrawableRect(num, num, num + 50, num + 50, Color.red);
                Graphics g = getGraphics();
                rect.draw(g);
                rects.add(rect);
            }
        });

        cr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final Random random = new Random();
                int num = random.nextInt(200);
                ColoredRect rect = new ColoredRect(num, num, num + 50, num + 50, Color.BLUE, Color.CYAN);
                Graphics g = getGraphics();
                rect.draw(g);
                rects.add(rect);
            }
        });
        saveToFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*try{
                    File myFile = new File("file3.txt");
                    FileOutputStream outFile = new FileOutputStream(myFile);
                    ObjectOutputStream oos = new ObjectOutputStream(outFile);
                    oos.writeObject(rects);
                    oos.close();
                }
                catch(IOException i){}
                catch (FileNotFoundException i){
                    System.out.println("Невозможно произвести запись в файл:");}
                catch(IOException i){
                    System.out.println("Ошибка");
                }*/
                try {

                    ObjectOutputStream obj_out_stream = new ObjectOutputStream(new FileOutputStream("file3.txt"));
                    obj_out_stream.writeObject(rects);
                    obj_out_stream.close();
                    System.out.println("Saved!");
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
                /*try{
                    File myFile = new File("file3.txt");
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myFile.txt"));
                    rects = (ArrayList<Rectangle>)ois.readObject();
                    ois.close();
                    repaint();
                }
                catch(IOException i){
                    System.out.println("Ошибка");
                }*/
            }
        });

        this.add(r);
        this.add(cr);
        this.add(dr);
        this.add(loadFromFile);
        this.add(saveToFile);


        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                last_x = e.getX(); last_y = e.getY();

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                int x = e.getX(), y= e.getY();
                for (Rectangle rect : rects){
                    if (last_x >= rect.getX1() && last_x <= rect.getX2() && last_y >= rect.getY1() && last_y <= rect.getY2()){
                        if((e.getModifiers()&MouseEvent.BUTTON1_MASK)!=0){
                            rect.move(x - last_x, y - last_y);
                            repaint();
                            last_x = x; last_y = y;
                        }
                    }
                }
            }
        });
    }

    public void loadRects () throws IOException{

    }

    public void saveRects() throws IOException{

    }

    public void paint(Graphics g) {
        for (Rectangle rect : rects)
            rect.draw(g);
    }

}
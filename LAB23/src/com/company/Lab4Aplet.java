package com.company;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Lab4Aplet extends Applet{
    List<Rectangle> rects = new ArrayList<>();
    int last_x, last_y;

    public void init(){
        Button r = new Button("Rect");
        Button cr = new Button("ColoredRect");
        Button dr = new Button("DrawableRect");

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
        this.add(r);
        this.add(cr);
        this.add(dr);



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

    public void paint(Graphics g) {
        for (Rectangle rect : rects)
            rect.draw(g);
    }

}

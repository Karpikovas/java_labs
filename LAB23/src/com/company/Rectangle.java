package com.company;

import java.awt.*;
import java.io.Serializable;

public class Rectangle implements Serializable {
    private int x1;
    private  int y1;
    private  int x2;
    private  int y2;
    private static final long serialVersionUID = 1L;

    //Конструктор без параметров, вырожденный прямоугольник
    public Rectangle(){
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }
    //Конструктор, принимающий координаты углов прямоугольника(x1, y1), (x2, y2)
    public Rectangle (int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    //Конструктор принимающий ширину (width) и высоту (height) прямоугольника
    public  Rectangle(int width, int height){
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = width;
        this.y2 = height;
    }

    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    //Метод, выдающий текущее состояние экземпляров прямоугольника
    public void rect_print(){
        System.out.println("Координаты прямоугольника:");
        System.out.println("\tЛевый верхний угол: (" + x1 + " ," + y1 + ")");
        System.out.println("\tПравый нижний угол: (" + x2 + " ," + y2 + ")");
    }
    //Метод, перемещающий прямоугольник по горизонтали на dx, по вертикали - на dy
    public void move(int dx, int dy){
        this.x1 += dx;
        this.x2 += dx;
        this.y1 += dy;
        this.y2 += dy;
    }
    //Метод, возвращающий объединение с другим прямоугольником
    public void Union(Rectangle rectangle){
        this.x1 = (rectangle.x1 > this.x1) ? this.x1 : rectangle.x1;
        this.y1 = (rectangle.y1 > this.y1) ? rectangle.y1 : this.y1;
        this.x2 = (rectangle.x2 > this.x2) ? rectangle.x2 : this.x2;
        this.y2 = (rectangle.y2 > this.y2) ? this.y2 : rectangle.y2;
    }
    public void draw(Graphics g){
        int width = this.getX2() - this.getX1();
        int height = this.getY2() - this.getY1();
        g.drawRect(this.getX1(),this.getY1(),width,height);
    }
}

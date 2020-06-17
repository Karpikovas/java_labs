package com.company;
import java.awt.*;
import java.io.Serializable;

public class ColoredRect extends DrawableRect implements Serializable {
    private Color inColor;

    public ColoredRect(){
        super();
    }
    public ColoredRect(int x1, int y1, int x2, int y2, Color color1, Color color2){
        super(x1, y1, x2, y2, color1);
        this.inColor = color2;
    }
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(inColor);
        int width = this.getX2() - this.getX1();
        int height = this.getY2() - this.getY1();
        g.fillRect(this.getX1(),this.getY1(),width,height);
    }
}

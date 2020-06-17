package com.company;
import java.awt.*;
import java.io.Serializable;

public class DrawableRect extends Rectangle implements Serializable {
    private Color outColor;


    public DrawableRect(){
        super();
    }

    public Color getOutColor() {
        return outColor;
    }

    public DrawableRect(int x1, int y1, int x2, int y2, Color color){
        super(x1, y1, x2, y2);
        this.outColor = color;
    }

    public void draw(Graphics g){
        g.setColor(this.outColor);
        super.draw(g);
    }
}

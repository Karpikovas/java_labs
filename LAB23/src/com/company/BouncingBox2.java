package com.company;
import java.applet.*;
import java.awt.*;
import java.util.*;

public class BouncingBox2 extends Applet implements Runnable {
    final Random random = new Random();
    Rectangle array[] = new Rectangle[30];
    int dx = 10, dy = 20;
    int dxAr[] = new int[30];
    int dyAr[] = new int[30];// Движение круга по горизонт и вертик
    Thread animator; // Нить, которая осуществляет анимацию
    volatile boolean pleaseStop; // Флаг остановки движения


    public BouncingBox2(){
        for (int i = 0; i < 15; i++)
            dxAr[i] = dx;
        for (int i = 0; i < 15; i++)
            dyAr[i] = dy;
        for (int i = 15; i < 30; i++)
            dxAr[i] = -dx;
        for (int i = 15; i < 30; i++)
            dyAr[i] = -dy;
        for (int i = 0; i < 15; i++){
            /*int x1 = random.nextInt(50);
            int y1 = random.nextInt(50);
            int x2 = x1 + 20;
            int y2 = y1 + 20;
            array[i] = new Rectangle(x1, y1, x2, y2);*/
            int num = random.nextInt(100);
            array [i] = new Rectangle(num, num, num + 20, num + 20);
        }
        for (int i = 10; i < 20; i++){
            /*int x1 = 80 + random.nextInt(50);
            int y1 = 80 + random.nextInt(50);
            int x2 = x1 + 20;
            int y2 = y1 + 20;
            array[i] = new DrawableRect(x1, y1, x2, y2, Color.red);*/
            int num = 100 + random.nextInt(100);
            array [i] = new DrawableRect(num, num, num + 20, num + 20, Color.red);
        }
        for (int i = 20; i < 30; i++){
            /*int x1 = 170 + random.nextInt(50);
            int y1 = 170 + random.nextInt(50);
            int x2 = x1 + 20;
            int y2 = y1 + 20;
            array [i] = new ColoredRect(x1, y1, x2, y2, Color.magenta, Color.CYAN);*/
            int num = 200 + random.nextInt(50);
            array [i] = new ColoredRect(num, num, num + 20, num + 20, Color.BLUE, Color.CYAN);
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 30; i++)
            array[i].draw(g);
    }

    public void animate() {
        for (int i = 0; i < 30; i++) {
            int width = 400, height = 300;
            //Получение размера окна программы
            if ((array[i].getX1() + dxAr[i] < 0) || (array[i].getX2() + dxAr[i] > width)) dxAr[i] = -dxAr[i];
            if ((array[i].getY1() + dyAr[i] < 0) || (array[i].getY2() + dyAr[i] > height)) dyAr[i] = -dyAr[i];
            // Изменение координат круга, по сути - движение.

            array[i].setX1(array[i].getX1() + dxAr[i]);
            array[i].setX2(array[i].getX2() + dxAr[i]);
            array[i].setY1(array[i].getY1() + dyAr[i]);
            array[i].setY2(array[i].getY2() + dyAr[i]);
            //"Просим" браузер вызвать метод paint() для отрисовки
            // круга в новой позиции
        }

        repaint();
    }
    /*Это метод из интерфейса Runnable. Это тело потока исполнения,
осуществляющего анимацию. Сам поток создается и
запускается методом start()
*/
    public void run() {
        while(!pleaseStop) { // Цикл до тех пор, пока не будет
            //команды остановиться.
            animate(); // Обновляем положение и перерисовываем
            try { Thread.sleep(100); } // Ждем 100 миллисекунд
            catch(InterruptedException e) {} // Игнорируем прерывания
        }
    }
    //Запускаем анимацию при запуске апплета браузером
    public void start() {
        animator = new Thread(this); // Создаем поток исполнения
        pleaseStop = false; // Пока не просим его остановиться
        animator.start(); // Запускаем поток
    }
    //Останавливаем анимацию, когда браузер останавливает апплет
    public void stop() { pleaseStop = true; }
}

package com.company;
import java.applet.*;
import java.awt.*;

//Создаем собственный класс,который наследуется от класса Applet
//Данный класс реализует методы интерфейса Runnable
public class BouncingBox extends Applet implements Runnable {
    ColoredRect rect = new ColoredRect(0, 0, 50, 50, Color.BLACK, Color.BLUE);
    int dx = 10, dy = 20; // Движение круга по горизонт и вертик
    Thread animator; // Нить, которая осуществляет анимацию
    volatile boolean pleaseStop; // Флаг остановки движения


    //Метод для рисования окружности красным цветом
    public void paint(Graphics g) {
        rect.draw(g);
    }
    //Метод двигает круг и "отражает" его при ударе круга о стенку,
//затем вызывает перерисовку.
//Данный метод вызывается многократно анимационным потоком
    public void animate() {
        int width = 400, height = 300; //Получение размера окна программы
        if ((rect.getX1() + dx < 0) || (rect.getX2() + dx > width))  dx = -dx;
        if ((rect.getY1() + dy < 0) || (rect.getY2() + dy > height)) dy = -dy;
        // Изменение координат круга, по сути - движение.
        rect.setX1(rect.getX1() + dx);
        rect.setX2(rect.getX2() + dx);
        rect.setY1(rect.getY1() + dy);
        rect.setY2(rect.getY2() + dy);
        //"Просим" браузер вызвать метод paint() для отрисовки
        // круга в новой позиции
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

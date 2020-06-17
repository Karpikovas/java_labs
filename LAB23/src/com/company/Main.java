package com.company;

public class Main {

    public static void main(String[] args) {

	    Rectangle test1 = new Rectangle(2, 8, 5, 4);
        Rectangle test2 = new Rectangle(4, 5);
        Rectangle test3 = new Rectangle();
        test1.rect_print();
        test2.rect_print();
        test3.rect_print();

        test1.move(4, 4);
        test1.rect_print();

        test1.Union(test2);
        test1.rect_print();
    }
}

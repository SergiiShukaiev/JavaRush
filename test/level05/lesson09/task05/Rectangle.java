package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    double top;
    double left;
    double width;
    double heigth;

    public Rectangle(double top, double left, double width, double heigth){
        this.top=top;
        this.left=left;
        this.width=width;
        this.heigth=heigth;
    }//напишите тут ваш код

    public Rectangle(double top, double left){
        this.top=top;
        this.left=left;
        this.width=0;
        this.heigth=0;
    }

    public Rectangle(double top, double left, double width){
        this.top=top;
        this.left=left;
        this.width=width;
        this.heigth=width;
    }
    public Rectangle(Rectangle copy, double top, double left, double width, double heigth){
        this.top=top;
        this.left=left;
        this.width=width;
        this.heigth=heigth;
    }

}

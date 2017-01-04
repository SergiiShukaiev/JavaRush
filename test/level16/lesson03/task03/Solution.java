package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread sp1=new SpecialThread();
        Thread thread1=new Thread(sp1);

        SpecialThread sp2=new SpecialThread();
        Thread thread2=new Thread(sp2);

        SpecialThread sp3=new SpecialThread();
        Thread thread3=new Thread(sp3);

        SpecialThread sp4=new SpecialThread();
        Thread thread4=new Thread(sp4);

        SpecialThread sp5=new SpecialThread();
        Thread thread5=new Thread(sp5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}

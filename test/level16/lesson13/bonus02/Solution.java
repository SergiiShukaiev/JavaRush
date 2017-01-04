package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static{
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args){
        Thread thread2=threads.get(1);
        thread2.start();
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex){}
        thread2.interrupt();

        Thread thread4=threads.get(3);
        Message mes=(Message)thread4;
        thread4.start();
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex){}
        mes.showWarning();
        System.out.println(thread4.isAlive());


    }

    public static class Thread1 extends Thread{
        public void run(){

            while(true){}
        }
    }

    public static class Thread2 extends Thread{
        public void run()
        {
                try
                {
                    while (!isInterrupted()){}

                    throw new InterruptedException();
                }
                catch (InterruptedException ex)
                {
                    System.out.println("InterruptedException");
                }
            }

    }
    public static class Thread3 extends Thread{
        public void run()
        {
                try
                {
                    while (true)
                    {
                        System.out.println("Ура");
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                }
                catch (InterruptedException ex)
                {
                }

        }
    }
    public static class Thread4 extends Thread implements Message{
        public void showWarning(){
            this.interrupt();
            try{
                this.join();
            } catch(Exception ex){}
        }

        public void run(){
            Thread current=Thread.currentThread();
            while(!current.interrupted()){}
        }
    }
    public static class Thread5 extends Thread{
        public void run(){
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            int sum=0;
            try{
                while(!isInterrupted()){
                 String  str=reader.readLine();
                    if (str.equals("N")){
                        this.interrupt();
                    } else{
                    int in=Integer.parseInt(reader.readLine());
                    sum +=in;}
                }
                throw new InterruptedException();
            } catch (IOException ex){}
            catch (InterruptedException ex){
                System.out.println(sum);
            }
        }
    }
}
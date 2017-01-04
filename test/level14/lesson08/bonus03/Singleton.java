package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Алина on 08.10.2016.
 */
public class Singleton
{
    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
       if (instance==null)
           instance=new Singleton();
        return instance;
    }
}

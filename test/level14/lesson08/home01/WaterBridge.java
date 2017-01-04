package com.javarush.test.level14.lesson08.home01;

/**
 * Created by Алина on 07.10.2016.
 */
public class WaterBridge implements Bridge
{
   public int getCarsCount(){

       int num=(int)(Math.random()*1000);
       return num;
   }
}

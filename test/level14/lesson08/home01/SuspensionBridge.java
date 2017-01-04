package com.javarush.test.level14.lesson08.home01;

/**
 * Created by Алина on 07.10.2016.
 */
public class SuspensionBridge implements Bridge
{  Bridge o;
    int num;
    public int getCarsCount(){

       if (o instanceof WaterBridge)
        num=(int)(Math.random()*1000);

        if (o instanceof SuspensionBridge)
            num=(int)(Math.random()*100);

        return num;}
}

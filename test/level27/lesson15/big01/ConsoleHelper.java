package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алина on 01.12.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        String s="";

            s = reader.readLine();

        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list=new ArrayList<Dish>();
        String order;
        writeMessage("Выберите блюдо из меню");
        writeMessage(Dish.allDishesToString());
        if(Dish.values().length>0){
        while(!(order=readString()).equalsIgnoreCase("exit"))
        {
            try
            {
                list.add(Dish.valueOf(order));
            }catch(IllegalArgumentException ex){
                writeMessage(order+" is not detected");
            }
        }
        }
        return list;

    }
}

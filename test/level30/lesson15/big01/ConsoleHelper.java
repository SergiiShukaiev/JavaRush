package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алина on 05.12.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String result=null;
        while(result==null)
        try{
            result=reader.readLine();
        } catch(IOException ex){
            writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
        }
        return result;
    }


    public static int readInt(){
        int num=0;
        while (true)
            try
            {
                num = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException ex)
            {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        return num;
    }
}

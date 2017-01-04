package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Алина on 07.10.2016.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth(){
        return 112;
    }
    String getDescription(){
        String result=super.getDescription();
        result=result + " Моя страна - ";
        result=result+Country.RUSSIA;
        result=result+". Я несу ";
        result=result+getCountOfEggsPerMonth();
        result=result+" яиц в месяц.";
        return result;
    }
}
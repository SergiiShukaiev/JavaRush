package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Алина on 10.10.2016.
 */
public class TeaMaker extends DrinkMaker
{
    void pour(){
        System.out.println("Заливаем водой");
    }
    void getRightCup(){
        System.out.println("Берем чашку для чая");
    }
    void putIngredient(){
        System.out.println("Насыпаем чай");
    }
}

package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Алина on 01.12.2016.
 */
public class Order
{
    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet=tablet;
        initDishes();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public Tablet getTablet()
    {
        return tablet;
    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "": "Your order: "+dishes+" of "+tablet;
    }


    public int getTotalCookingTime(){
        int totalMin=0;
        for(Dish d:dishes){
            totalMin +=d.getDuration();
        }
        return totalMin;
    }


    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    protected void initDishes() throws IOException
    {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes=ConsoleHelper.getAllDishesForOrder();

    }
}

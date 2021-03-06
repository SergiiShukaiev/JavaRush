package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Алина on 02.12.2016.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;  //начальная сумма, стоимость рекламы в копейках
        this.hits = hits;  //количество оплаченных показов
        this.duration = duration;  //продолжительность в секундах
        this.amountPerOneDisplaying=initialAmount/hits;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public int getHits()
    {
        return hits;
    }

    public void revalidate(){
        if (hits <= 0) throw new UnsupportedOperationException();
        else {
            amountPerOneDisplaying = Math.round(initialAmount * 1.0 / hits);
            initialAmount -= amountPerOneDisplaying;
            hits--;
        }
    }
}

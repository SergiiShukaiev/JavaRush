package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Алина on 25.11.2016.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance){
        this.name=name;
        this.speed=speed;
        this.distance=distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move(){
        distance += Math.random()*speed;
    }

    public void print(){
        int n=(int) distance;
        String p="";
        for(int i=0; i<n; i++)
            p+=".";
        System.out.println(p+name);

    }
}

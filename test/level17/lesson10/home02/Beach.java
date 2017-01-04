package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.ArrayList;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        int dist=(int)(distance - o.getDistance());
        int qual=quality-o.getQuality();
        return 2*name.compareTo(o.getName())+ 2*dist + qual;
    }


    public static void main(String[] args){
        ArrayList<Beach> beach=new ArrayList<Beach>();
        beach.add(new Beach("aaa", 145.2f, 4));
        beach.add(new Beach("aba", 45.2f, 3));
        beach.add(new Beach("baa", 14.2f, 2));
        beach.add(new Beach("abb", 1045.2f, 43));
        beach.add(new Beach("bba", 146.2f, 5));
        beach.add(new Beach("bbb", 115.2f, 7));
        beach.add(new Beach("bab", 95.2f, 8));
        beach.add(new Beach("caa", 1.2f, 0));

        for(Beach b:beach)
            System.out.println(b.getName()+" "+b.getDistance()+" "+b.getQuality());
    }
}

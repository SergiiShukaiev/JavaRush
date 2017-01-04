package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Алина on 25.11.2016.
 */
public class Hippodrome
{
    public static Hippodrome game;
    private static ArrayList<Horse> horses=new ArrayList<Horse>();
    public ArrayList<Horse> getHorses(){
        return horses;
    }
    public static void main(String[] args){
        game=new Hippodrome();
        Horse horse1=new Horse("BMW", 3, 0);
        Horse horse2=new Horse("Audi", 3, 0);
        Horse horse3=new Horse("Honda", 3, 0);

        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game.run();
        game.printWinner();
    }

    public void run(){
        for (int i=1; i<=100; i++){
            try{
                Thread.sleep(200);
            } catch (InterruptedException ex){}
            move();
            print();
        }

    }

    public void move(){
        for(Horse h:horses)
            h.move();
    }

    public void print(){
        for (Horse h:horses)
            h.print();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner=horses.get(0);
        for (Horse h:horses){
            if (h.getDistance()>winner.getDistance())
                winner=h;
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }
}

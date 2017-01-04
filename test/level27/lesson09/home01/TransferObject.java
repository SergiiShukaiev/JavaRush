package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get()
    {
        while(!this.isValuePresent){
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        this.isValuePresent=false;
        this.notifyAll();
        return value;
    }

    public synchronized void put(int value) {
        while(this.isValuePresent){
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        this.value = value;
        System.out.println("Put: " + value);
        this.isValuePresent=true;
        this.notifyAll();
    }
}

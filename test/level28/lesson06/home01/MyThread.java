package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Алина on 03.12.2016.
 */
public class MyThread extends Thread
{
    private static int count;
    private int id=++count;

    public void setSetPriority(){
        int priority=id%10;
        if (priority==0) priority=10;
        int maxPriority = Thread.currentThread().getThreadGroup().getMaxPriority();
        if (priority > maxPriority) priority = maxPriority;
        this.setPriority(priority);
    }



    public MyThread()
    {
        this.setSetPriority();
    }


    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        this.setSetPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        this.setSetPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        this.setSetPriority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        this.setSetPriority();
    }

    public MyThread(String name)
    {
        super(name);
        this.setSetPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        this.setSetPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        this.setSetPriority();
    }


}

package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Алина on 28.11.2016.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }


    @Override
    public void run()
    {
        try{
            String s="";
            int i=0;
            while(true){
                s=(String)queue.poll();
                System.out.println(s);
                Thread.sleep(500);
        }
        }catch(InterruptedException ex){
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }
}

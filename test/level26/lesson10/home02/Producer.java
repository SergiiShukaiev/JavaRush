package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Алина on 28.11.2016.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        Thread thread=Thread.currentThread();
        String threadName=thread.getName();
        int i=0;

            while (!thread.isInterrupted())
            {
                i++;
                try
                {
                    map.put(String.valueOf(i), "Some text for "+i);
                        Thread.sleep(500);
                }
                catch (InterruptedException ex)
                {
                    System.out.println(String.format("%s thread was terminated", threadName));
                }
            }

    }
}

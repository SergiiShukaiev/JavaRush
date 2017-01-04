package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
 private Thread thread;
    private String name;
    @Override
    public void run() {
        try
        {
            while (!thread.isInterrupted())
            {

                Thread.sleep(0);
                System.out.println(name);
                Thread.sleep(90);
            }
        }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

    }

    @Override
    public void start(String threadName)
    {
        name=threadName;
        thread= new Thread(this);
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();

    }
}

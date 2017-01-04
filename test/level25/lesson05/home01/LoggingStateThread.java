package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Алина on 27.11.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread loggingStateThread;
        public LoggingStateThread(Thread thread){
            setDaemon(true);
            this.loggingStateThread=thread;
        }
        public void run(){
            State state=loggingStateThread.getState();
            System.out.println(state);
            while(state!=State.TERMINATED){
                if (state!=loggingStateThread.getState()){
                    state=loggingStateThread.getState();
                    System.out.println(state);
                }
            }
        }

}

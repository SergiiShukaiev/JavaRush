package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Алина on 06.12.2016.
 */
public class BotClient extends Client
{
    private static volatile Set<String> botNames=new HashSet<String>();

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName;
        if (botNames.size() >= 100) throw new RuntimeException("Число ботов превысило допустимый предел");
        do {
            botName = String.format("date_bot_%02d", new Random().nextInt(100));
        } while (botNames.contains(botName));
        botNames.add(botName);
        return botName;
    }


    public class BotSocketThread extends SocketThread
    {
        //Task 19.1.
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        //Task 19.2
        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            String[]array=message.split(": ");
            if (array.length==2){
                String userName=array[0];
                String text=array[1].toLowerCase();
                String dateTimeFormat=null;

                switch(text){
                    case "дата":
                        dateTimeFormat="d.MM.YYYY";
                        break;
                    case "день":
                        dateTimeFormat="d";
                        break;
                    case "месяц":
                        dateTimeFormat="MMMM";
                        break;
                    case "год":
                        dateTimeFormat="YYYY";
                        break;
                    case "время":
                        dateTimeFormat="H:mm:ss";
                        break;
                    case "час":
                        dateTimeFormat="H";
                        break;
                    case "минуты":
                        dateTimeFormat="m";
                        break;
                    case "секунды":
                        dateTimeFormat="s";
                        break;
                }

                if (dateTimeFormat !=null){
                    String answer=String.format("Информация для %s: %s",
                            userName, new SimpleDateFormat(dateTimeFormat).format(Calendar.getInstance().getTime()));
                    sendTextMessage(answer);
                }
            }
        }
    }


    public static void main(String[] args){
        new BotClient().run();
    }
}







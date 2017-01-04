package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Алина on 06.12.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected=false;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("введите номер порта");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        Message message;
        try{
            message=new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch(IOException ex){
            ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            clientConnected=false;
        }
    }

    public void run(){
        // Task 14.1.1
        SocketThread socketThread=getSocketThread();

        // Task 14.1.2
        socketThread.setDaemon(true);

        // Task 14.1.3
        socketThread.start();

        // Task 14.1.4
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }catch (InterruptedException e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка соединения");
                return;
            }

        // Task 14.1.5
        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'");

        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while(clientConnected){
            String text;
            // Task 14.1.6
            if(!(text=ConsoleHelper.readString()).equals("exit"))
            {
                // Task 14.1.7
                if (shouldSentTextFromConsole()) sendTextMessage(text);
            }
            else return;
        }
    }

    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){  // выводит в консоль текст из сообщения
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){             //выводит в консоль информацию о том, что
            ConsoleHelper.writeMessage(userName + " присоединился к чату");   //участник с именем userName присоединился к чату
        }

        protected void informAboutDeletingNewUser(String userName){   //выводит в консоль информацию о том, что
            ConsoleHelper.writeMessage(userName + "покинул чат");     //участник с именем userName покинул чат
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected=clientConnected;
            synchronized(Client.this){
                Client.this.notify();
            }
        }

        //Task 16.1
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            boolean accepted=false;
            while(!accepted){
               Message message=connection.receive();

                switch (message.getType()) {
                case NAME_REQUEST :
                    ConsoleHelper.writeMessage("вводите имя пользователя");
                    String clientName=getUserName();
                    connection.send(new Message(MessageType.USER_NAME, clientName));
                    break;

                case NAME_ACCEPTED:
                    notifyConnectionStatusChanged(true);
                    return;

               default:
                    throw new IOException("Unexpected MessageType");
                }
            }
        }


        //Task 16.2
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (!Thread.currentThread().isInterrupted())
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }


        //Task 17.1
        public void run(){
            String serverAddress=getServerAddress();
            int serverPort=getServerPort();

            try (Socket socket=new Socket(serverAddress, serverPort))
            {
                Client.this.connection=new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }

    }

    public static void main(String[] args){
        Client client=new Client();
        client.run();
    }
}

package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Алина on 05.12.2016.
 */
public class Server
{
    final private static Map<String, Connection> connectionMap = new java.util.concurrent.ConcurrentHashMap<>(); //ключ - имя клиента, значением - соединение с ним


    public static void sendBroadcastMessage(Message message){
        for (String clientName: connectionMap.keySet()){
            try
            {
                connectionMap.get(clientName).send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: "+clientName);
            }
        }
    }

    public static void main(String[] args){
        ConsoleHelper.writeMessage("Нужен номер порта");
        int port=ConsoleHelper.readInt();

        try (ServerSocket serverSocket=new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен");

            while(true){
                Socket socket=serverSocket.accept();
                Handler handler=new Handler(socket);
                handler.start();
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("ошибка соединения");
        }
    }



    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket)
        {
            super();
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
           String clientName=null;

            while(true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    clientName = message.getData();
                    if (!clientName.isEmpty() && !connectionMap.keySet().contains(clientName))
                    {
                        connectionMap.put(clientName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }

            return clientName;
        }


        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String clientName: connectionMap.keySet()){
                if (!clientName.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
                }
            }
        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message message =null;
            Message newMessage = null;

            while(true)
            {
                message = connection.receive();

                if (message.getType() == MessageType.TEXT)
                {
                    newMessage = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(newMessage);
                } else {
                    ConsoleHelper.writeMessage("Сообщение не является текстом");
                }
            }
        }


        public void run(){
            String clientName=null;

            // Task 11.1
            ConsoleHelper.writeMessage("установлено новое соединение с удаленным адресом: " +socket.getRemoteSocketAddress());

            try (Connection connection=new Connection(socket))
            {

                // Task 11.3
                clientName=serverHandshake(connection);

                // Task 11.4
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                // Task 11.5
                sendListOfUsers(connection, clientName);

                // Task 11.6
                serverMainLoop(connection, clientName);
            }

            // Task 11.8
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }

            // Task 11.9
            if (clientName !=null){
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            // Task 11.10
            ConsoleHelper.writeMessage("соединение с удаленным адресом закрыто");

        }
    }
}

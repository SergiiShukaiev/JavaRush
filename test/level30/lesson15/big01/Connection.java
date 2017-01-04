package com.javarush.test.level30.lesson15.big01;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Алина on 05.12.2016.
 */
public class Connection implements Closeable
{
    final private Socket socket;
    final private ObjectOutputStream out;
    final private ObjectInputStream in;

    public Connection(Socket socket) throws IOException
    {
            this.socket = socket;
            this.out=new ObjectOutputStream(this.socket.getOutputStream());
            this.in=new ObjectInputStream(this.socket.getInputStream());
    }

    public void send(Message message) throws IOException{
        synchronized (out){
            out.writeObject(message);
        }
    }

    public Message receive() throws IOException, ClassNotFoundException{
        Message message=null;
        synchronized (in){
            message=(Message)in.readObject();
        }
        return message;
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }


    @Override
    public void close() throws IOException
    {
        socket.close();
        out.close();
        in.close();
    }
}

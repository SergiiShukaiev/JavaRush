package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by Алина on 06.12.2016.
 */
public class ClientGuiController extends Client
{
    private ClientGuiModel model;
    private ClientGuiView view;

    public ClientGuiController()
    {
        this.model=new ClientGuiModel();
        this.view=new ClientGuiView(this);
    }

    //Task 21.5
    @Override
    protected SocketThread getSocketThread()
    {
        return new GuiSocketThread();
    }

    @Override
    public void run()
    {
        getSocketThread().run();
    }

    @Override
    protected String getServerAddress()
    {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort()
    {
        return view.getServerPort();
    }

    @Override
    protected String getUserName()
    {
        return view.getUserName();
    }

    // Task 21.6
    public ClientGuiModel getModel(){
        return model;
    }

    //Task 21.4
    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message)
        {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName)
        {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName)
        {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }


    //Task 21.7
    public static void main(String[] args){
        new ClientGuiController().run();
    }
}

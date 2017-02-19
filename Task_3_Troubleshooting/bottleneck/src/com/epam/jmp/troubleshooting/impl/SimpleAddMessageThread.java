package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.MessageClient;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimpleAddMessageThread extends Thread
{
    private String userName;

    public SimpleAddMessageThread(String userName)
    {
        this.userName = userName;
    }

    @Override
    public void run()
    {
        System.out.println(userName + " started");
        MessageClient messageClient = new SimpleMessageQueueClient(userName);
        for (int i = 0; i < 10; i++)
        {
            messageClient.addMessageToQueue("message " + i);
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                //ignore exception
            }
        }
        System.out.println(userName + " ended");
    }
}

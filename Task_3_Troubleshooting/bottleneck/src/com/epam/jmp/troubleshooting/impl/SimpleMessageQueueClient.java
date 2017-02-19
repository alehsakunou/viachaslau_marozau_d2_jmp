package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.MessageClient;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimpleMessageQueueClient implements MessageClient
{
    private final static Queue<String> messageQueue = new LinkedList<String>();
    private String userName;

    public SimpleMessageQueueClient(String userName)
    {
        this.userName = userName;
    }

    @Override
    public void addMessageToQueue(String message)
    {
        synchronized (messageQueue)
        {
            messageQueue.offer(String.format("Message from %s: %s", userName, message));
        }
    }

    @Override
    public boolean hasNext()
    {
        return messageQueue.size() > 0;
    }

    @Override
    public String getMessageFromQueue()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            //ignore exception
        }
        String message = null;
        synchronized (messageQueue)
        {
            message = messageQueue.poll();
        }
        return message;
    }
}

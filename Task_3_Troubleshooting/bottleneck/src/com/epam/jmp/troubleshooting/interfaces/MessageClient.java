package com.epam.jmp.troubleshooting.interfaces;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public interface MessageClient
{
    boolean hasNext();

    void addMessageToQueue(String message);

    String getMessageFromQueue();
}

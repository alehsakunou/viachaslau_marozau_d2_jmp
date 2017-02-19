package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.MessageClient;

import java.io.PrintStream;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimplePrintMessageThread extends Thread
{
    PrintStream printStream;

    public SimplePrintMessageThread(String threadName, PrintStream printStream)
    {
        super(threadName);
        this.printStream = printStream;
    }

    @Override
    public void run()
    {
        final String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        MessageClient messageClient = new SimpleMessageQueueClient(threadName);
        while (messageClient.hasNext())
        {
            String message = messageClient.getMessageFromQueue();
            printStream.println(message);
        }
        System.out.println(threadName + " ended");
    }
}

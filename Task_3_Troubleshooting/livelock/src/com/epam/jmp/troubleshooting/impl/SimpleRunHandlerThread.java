package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.ResourceHandler;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimpleRunHandlerThread extends Thread
{
    ResourceHandler usedResourceHandler;
    CommonResource commonResource;
    ResourceHandler[] otherResourceHandlers;

    public SimpleRunHandlerThread(String threadName, ResourceHandler usedResourceHandler, CommonResource commonResource,
        ResourceHandler[] otherResourceHandlers)
    {
        super(threadName);
        this.usedResourceHandler = usedResourceHandler;
        this.commonResource = commonResource;
        this.otherResourceHandlers = otherResourceHandlers;
    }

    @Override
    public void run()
    {
        String name = currentThread().getName();
        System.out.println(name + " started");
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println(name + " interrupted");
        }
        usedResourceHandler.handle(commonResource, otherResourceHandlers);
        System.out.println(name + " ended");
    }
}

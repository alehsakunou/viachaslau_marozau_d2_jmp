package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.ResourceHandler;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimpleSyncQueueResourceHandlerImpl implements ResourceHandler
{
    private String name;
    private boolean active;

    public SimpleSyncQueueResourceHandlerImpl(String name, boolean active)
    {
        this.name = name;
        this.active = active;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean isActive()
    {
        return active;
    }

    @Override
    public synchronized void handle(CommonResource commonResource, ResourceHandler[] otherResourceHandlers)
    {
        label:
        while (active)
        {
            // wait for the resource to become available.
            if (commonResource.getHandler() != this)
            {
                try
                {
                    wait(500);
                }
                catch (InterruptedException e)
                {
                    System.out.println(name + " interrupted");
                }
                continue label;
            }
            // If other handlers is also active let it do it's work first
            for (ResourceHandler otherResourceHandler : otherResourceHandlers){
                if (otherResourceHandler.isActive())
                {
                    System.out.println(name + " handing over the resource to the " +
                        otherResourceHandler);
                    commonResource.setHandler(otherResourceHandler);
                    continue label;
                }
            }
            //now use the commonResource
            System.out.println(name + " working on the common resource");
            active = false;
            for (ResourceHandler otherResourceHandler : otherResourceHandlers)
            {
                if (otherResourceHandler != null && otherResourceHandler.isActive())
                    commonResource.setHandler(otherResourceHandler);
                break;
            }
        }
    }

    @Override
    public String toString()
    {
        return name;
    }
}

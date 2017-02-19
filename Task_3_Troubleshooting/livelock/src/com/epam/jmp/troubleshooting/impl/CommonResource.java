package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.ResourceHandler;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class CommonResource
{
    private ResourceHandler handler;

    public CommonResource(ResourceHandler handler)
    {
        this.handler = handler;
    }

    public ResourceHandler getHandler()
    {
        return handler;
    }

    public synchronized void setHandler(ResourceHandler handler)
    {
        this.handler = handler;
    }
}

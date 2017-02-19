package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.ReadWriteResource;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimpleReadWriteResourceImpl implements ReadWriteResource
{
    private byte[] data;
    private final String resourceName;

    public SimpleReadWriteResourceImpl()
    {
        this.data = new byte[0];
        this.resourceName = "default resource";
    }

    public SimpleReadWriteResourceImpl(String resourceName, byte[] data)
    {
        this.data = data;
        this.resourceName = resourceName;
    }

    public String getResourceName()
    {
        return resourceName;
    }

    @Override
    public String toString()
    {
        return getResourceName();
    }

    @Override
    public synchronized byte[] read()
    {
        return data;
    }

    @Override
    public synchronized void write(byte[] byteArr)
    {
        data = byteArr;
    }
}

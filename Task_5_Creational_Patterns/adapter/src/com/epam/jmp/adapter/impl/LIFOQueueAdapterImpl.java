package com.epam.jmp.adapter.impl;

import com.epam.jmp.adapter.interfaces.QueueAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public class LIFOQueueAdapterImpl<T> implements QueueAdapter<T>
{
    private final List<T> list;

    public LIFOQueueAdapterImpl()
    {
        this.list = new ArrayList<T>();
    }

    public LIFOQueueAdapterImpl(List<T> list)
    {
        this.list = list;
    }

    @Override
    public T pop()
    {
        return list.remove(list.size() - 1);
    }

    @Override
    public void push(T element)
    {
        list.add(element);
    }
}

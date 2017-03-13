package com.epam.jmp.observer.impl;

import com.epam.jmp.observer.interfaces.ReadWordEvent;
import com.epam.jmp.observer.interfaces.ReadWordObserver;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public class CounterReadWordObserver implements ReadWordObserver
{
    private int count;

    public CounterReadWordObserver()
    {
        count = 0;
    }

    @Override
    public void processEvent(ReadWordEvent event)
    {
        String word = event.getWord();
        if (word != null && !word.isEmpty())
        {
            count++;
        }
    }

    @Override
    public String getResult()
    {
        return "Words count: " + count;
    }
}

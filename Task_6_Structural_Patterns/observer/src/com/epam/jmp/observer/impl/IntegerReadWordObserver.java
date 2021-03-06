package com.epam.jmp.observer.impl;

import com.epam.jmp.observer.interfaces.ReadWordEvent;
import com.epam.jmp.observer.interfaces.ReadWordObserver;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public class IntegerReadWordObserver implements ReadWordObserver
{
    private int summ;

    public IntegerReadWordObserver()
    {
        summ = 0;
    }

    @Override
    public void processEvent(ReadWordEvent event)
    {
        String word = event.getWord();
        if (word != null && !word.isEmpty())
        {
            if (word.matches("-?\\d+"))
            {
                try
                {
                    summ += Integer.parseInt(word);
                }
                catch (NumberFormatException e)
                {
                    //do nothing
                }
            }
        }
    }

    @Override
    public String getResult()
    {
        return "Integer summ: " + summ;
    }
}
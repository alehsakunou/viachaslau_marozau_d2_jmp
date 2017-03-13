package com.epam.jmp.observer.impl;

import com.epam.jmp.observer.interfaces.ReadWordEvent;

/**
 * Created by Viachaslau_Marozau on 3/13/2017.
 */
public class SimpleReadWordEventImpl implements ReadWordEvent
{
    String word;

    public SimpleReadWordEventImpl(String word)
    {
        this.word = word.trim();
    }

    @Override
    public String getWord()
    {
        return word;
    }
}

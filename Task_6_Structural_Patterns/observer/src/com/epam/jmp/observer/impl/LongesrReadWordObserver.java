package com.epam.jmp.observer.impl;

import com.epam.jmp.observer.interfaces.ReadWordEvent;
import com.epam.jmp.observer.interfaces.ReadWordObserver;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public class LongesrReadWordObserver implements ReadWordObserver
{
    private String longestWord;

    public LongesrReadWordObserver()
    {
        longestWord = "";
    }

    @Override
    public void processEvent(ReadWordEvent event)
    {
        String word = event.getWord();
        if (word != null && !word.isEmpty() && (longestWord.length() < word.length()))
        {
            longestWord = word;
        }
    }

    @Override
    public String getResult()
    {
        return "Longest word" + longestWord;
    }
}
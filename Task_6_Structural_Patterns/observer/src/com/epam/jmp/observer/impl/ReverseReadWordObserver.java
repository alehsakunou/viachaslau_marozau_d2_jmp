package com.epam.jmp.observer.impl;

import com.epam.jmp.observer.interfaces.ReadWordEvent;
import com.epam.jmp.observer.interfaces.ReadWordObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Viachaslau_Marozau on 3/13/2017.
 */
public class ReverseReadWordObserver implements ReadWordObserver
{
    private StringBuilder revertStringBuilder;

    public ReverseReadWordObserver()
    {
        revertStringBuilder = new StringBuilder();
    }

    @Override
    public void processEvent(ReadWordEvent event)
    {
        String word = event.getWord();
        if (word != null && !word.isEmpty())
        {
            char[] revertCharArr = revertWord(word);
            revertStringBuilder.append(new String(revertCharArr)).append(" ");
        }
    }

    private char[] revertWord(String word)
    {
        char[] charArr = word.toCharArray();
        for (int left = 0, right = charArr.length - 1; left < right; left++, right--)
        {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
        }
        return charArr;
    }

    @Override
    public String getResult()
    {
        return "Reverse string: " + revertStringBuilder.toString();
    }
}

package com.epam.jmp.adapter.interfaces;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public interface QueueAdapter<T>
{
    T pop();

    void push(T element);
}

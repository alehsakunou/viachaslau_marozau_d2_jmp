package com.epam.jmp.iterator.impl;

import com.epam.jmp.iterator.interfaces.LIFOIterator;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public class SimpleLIFOIteratorImpl<E> implements LIFOIterator<E>
{
    private int index;
    private final List<E> list;

    public SimpleLIFOIteratorImpl(List<E> list)
    {
        this.list = list;
        this.index = 0;
    }

    @Override
    public void remove()
    {
        list.remove(index);
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action)
    {

    }

    @Override
    public void in(E e)
    {
        list.add(e);
    }

    @Override
    public E out()
    {
        E element = list.remove(list.size() - 1);
        return element;
    }

    @Override
    public boolean hasNext()
    {
        return list.size() > index;
    }

    @Override
    public E next()
    {
        E element = list.get(index);
        index++;
        return element;
    }
}

package com.epam.jmp.iterator.impl;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Viachaslau_Marozau on 3/13/2017.
 */
public class LIFOIreratedList<E> extends ArrayList<E>
{
    @Override
    public Iterator<E> iterator()
    {
        return new SimpleLIFOIteratorImpl(this);
    }
}

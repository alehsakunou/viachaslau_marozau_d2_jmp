package com.epam.jmp.iterator.interfaces;

    import java.util.Iterator;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public interface LIFOIterator<E> extends Iterator<E>
{
    void in(E e);

    E out();
}

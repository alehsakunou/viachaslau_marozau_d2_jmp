package com.epam.jmp.observer.interfaces;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public interface ReadWordObserver
{
    void processEvent(ReadWordEvent event);

    String getResult();
}

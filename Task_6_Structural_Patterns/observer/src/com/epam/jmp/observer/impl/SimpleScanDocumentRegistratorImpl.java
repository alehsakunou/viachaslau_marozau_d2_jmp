package com.epam.jmp.observer.impl;

import com.epam.jmp.observer.interfaces.ReadWordEvent;
import com.epam.jmp.observer.interfaces.ReadWordObserver;
import com.epam.jmp.observer.interfaces.ScanDocumentRegistrator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Viachaslau_Marozau on 3/13/2017.
 */
public class SimpleScanDocumentRegistratorImpl implements ScanDocumentRegistrator
{
    List<ReadWordObserver> observerSet;

    public SimpleScanDocumentRegistratorImpl()
    {
        this.observerSet = new ArrayList<ReadWordObserver>();
    }

    public SimpleScanDocumentRegistratorImpl(List<ReadWordObserver> observerSet)
    {
        this.observerSet = observerSet;
    }

    @Override
    public void addObserver(ReadWordObserver observer)
    {
        observerSet.add(observer);
    }

    @Override
    public ReadWordObserver[] gerObservers()
    {
        return observerSet.toArray(new ReadWordObserver[0]);
    }

    @Override
    public void scanDocument(String filePath) throws FileNotFoundException
    {
        File file = new File(filePath);
        scanDocument(file);
    }

    @Override
    public void scanDocument(File file) throws FileNotFoundException
    {
        Scanner scan = new Scanner(file);
        while (scan.hasNext())
        {
            String word = scan.next();
            ReadWordEvent event = new SimpleReadWordEventImpl(word);
            for (ReadWordObserver observer : observerSet)
            {
                observer.processEvent(event);
            }
        }
    }
}

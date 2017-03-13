package com.epam.jmp.observer.interfaces;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public interface ScanDocumentRegistrator
{
    void addObserver(ReadWordObserver observer);

    ReadWordObserver[] gerObservers();

    void scanDocument(String filePath) throws FileNotFoundException;

    void scanDocument(File file) throws FileNotFoundException;
}

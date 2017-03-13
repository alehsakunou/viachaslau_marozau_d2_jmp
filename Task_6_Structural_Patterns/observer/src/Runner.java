import com.epam.jmp.observer.impl.CounterReadWordObserver;
import com.epam.jmp.observer.impl.IntegerReadWordObserver;
import com.epam.jmp.observer.impl.LongesrReadWordObserver;
import com.epam.jmp.observer.impl.ReverseReadWordObserver;
import com.epam.jmp.observer.impl.SimpleScanDocumentRegistratorImpl;
import com.epam.jmp.observer.interfaces.ReadWordObserver;
import com.epam.jmp.observer.interfaces.ScanDocumentRegistrator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Viachaslau_Marozau on 3/12/2017.
 */
public class Runner
{
    private static Scanner inputScan;
    private static ScanDocumentRegistrator registrator;
    private static String defFileName;

    public static void main(String... args)
    {
        init();
        doApplicationLogic();
    }

    private static void init()
    {
        inputScan = new Scanner(System.in);
        registrator = new SimpleScanDocumentRegistratorImpl();
        registrator.addObserver(new CounterReadWordObserver());
        registrator.addObserver(new IntegerReadWordObserver());
        registrator.addObserver(new LongesrReadWordObserver());
        registrator.addObserver(new ReverseReadWordObserver());
        defFileName = "resources\\exampleToScan.txt";
    }

    private static void doApplicationLogic()
    {

        try
        {
            doIntroduce();
            doScanFile();
            goGetResults();
        }
        catch (IOException e)
        {
            System.out.println("System error: " + e.getMessage());
        }

    }

    private static void doIntroduce()
    {
        System.out.println("This project is demo for observer pattern\n");
    }

    private static void doScanFile() throws IOException
    {
        String fileName = readParam("file name:\n(you can use file " + defFileName + ")");
        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("File not found...\n");
            file.createNewFile();
            System.out.println("File created...\n");
        }
        registrator.scanDocument(file);
    }

    private static void goGetResults()
    {
        ReadWordObserver[] observerArr = registrator.gerObservers();
        for (ReadWordObserver observer : observerArr)
        {
            System.out.println(observer.getResult() + "\n");
        }
    }

    private static String readParam(String paramName)
    {
        System.out.println("Please, enter " + paramName + ":");
        if (inputScan.hasNext())
        {
            return inputScan.next();
        }
        return "";
    }
}

import com.epam.jmp.classloading.err.AppException;
import com.epam.jmp.classloading.interfaces.MathAction;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

/**
 * Created by Viachaslau_Marozau on 2/26/2017.
 */
public class Runner
{
    private static Scanner inputScan;
    private static String[] mathActionArr;
    private static String[] repeatArr;
    private static ClassLoader jarClassLoader;

    public static void main(String... args)
    {
        init();
        doApplicationLogic();
    }

    @SuppressWarnings("deprecation")
    private static void init()
    {
        inputScan = new Scanner(System.in);
        mathActionArr = new String[] {"Add", "Multiply", "Subtract", "Divide"};
        repeatArr = new String[] {"Yes", "No"};
        String path = System.getProperty("user.dir");
        final String jarPath = "/lib/mathActions.jar";
        String jarFilePath = path + jarPath;
        File jarFile = new File(jarFilePath);
        URL jarFileURL = null;
        try
        {
            jarFileURL = jarFile.toURL();
        }
        catch (MalformedURLException e)
        {
            throw new AppException("Can't found URL", e);
        }
        jarClassLoader = new URLClassLoader(new URL[] {jarFileURL});
    }

    private static void doApplicationLogic()
    {
        doIntroduce();
        boolean isRepeat = false;
        do
        {
            try
            {
                MathAction action = doCheckAction();
                double result = processMathAction(action);
                System.out.println(String.format("Result: %f", result));
            }
            catch (RuntimeException e)
            {
                System.out.println("We have an isssue: " + e.getMessage());

            }
            isRepeat = doRepeat();
        }
        while (isRepeat);
    }

    private static void doIntroduce()
    {
        System.out.println(
            "This is classloading task:\nYou check arithmetic action.\nThen we load it from jar file and execute.\nEnjoy)))\n\n");
    }

    private static MathAction doCheckAction()
    {
        System.out.println("Please, select math action:");
        int choiseNum = doSelectOption(mathActionArr);
        return getChoisedAction(choiseNum);
    }

    private static boolean doRepeat()
    {
        System.out.println("Repeat?");
        int choise = doSelectOption(repeatArr);
        return choise == 1;
    }

    private static double readParam(String paramName)
    {
        System.out.println("Please, enter " + paramName + " value:");
        if (inputScan.hasNextDouble())
        {
            return inputScan.nextDouble();
        }
        return 0;
    }

    private static int doSelectOption(String[] optionArray)
    {

        for (int i = 1; i <= optionArray.length; i++)
        {
            System.out.println(i + ". " + optionArray[i - 1]);
        }
        System.out.println();
        System.out.println("Enter selected option:");
        if (inputScan.hasNextInt())
        {
            return inputScan.nextInt();
        }
        return -1;
    }

    private static MathAction getChoisedAction(int choiseNum)
    {
        String className = "";
        switch (choiseNum)
        {
            case 1:
                className = "com.epam.jmp.classloading.impl.AddMathActionImpl";
                break;
            case 2:
                className = "com.epam.jmp.classloading.impl.MultiplyMathActionImpl";
                break;
            case 3:
                className = "com.epam.jmp.classloading.impl.SubtractMathActionImpl";
                break;
            case 4:
                className = "com.epam.jmp.classloading.impl.DivideMathActionImpl";
                break;
            default:
                throw new IllegalArgumentException("Incorrect shape number");
        }
        return dynamicLoadClass(className);
    }

    private static MathAction dynamicLoadClass(String className)
    {
        MathAction mathAction = null;
        try
        {
            Class loadedClass = jarClassLoader.loadClass(className);
            mathAction = (MathAction) loadedClass.newInstance();
        }
        catch (ClassNotFoundException e)
        {
            throw new AppException("Can't found class", e);
        }
        catch (IllegalAccessException e)
        {
            throw new AppException("Have no access", e);
        }
        catch (InstantiationException e)
        {
            throw new AppException("Can't create instance", e);
        }
        return mathAction;
    }

    private static double processMathAction(MathAction action)
    {
        double firstNumber = readParam("first number");
        double secondNumber = readParam("second number");
        return action.doMathAction(firstNumber, secondNumber);
    }
}

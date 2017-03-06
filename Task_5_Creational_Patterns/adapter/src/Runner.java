import com.epam.jmp.adapter.impl.LIFOQueueAdapterImpl;
import com.epam.jmp.adapter.interfaces.QueueAdapter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public class Runner
{
    private static Scanner inputScan;
    private static String[] lifoActions;
    private static String[] repeatArr;
    private static QueueAdapter<Double> queueAdapter;

    public static void main(String... args)
    {
        init();
        doApplicationLogic();
    }

    private static void init()
    {
        inputScan = new Scanner(System.in);
        lifoActions = new String[] {"pop element", "push element"};
        repeatArr = new String[] {"Yes", "No"};
        queueAdapter = new LIFOQueueAdapterImpl<Double>(new ArrayList<Double>());

    }

    private static void doApplicationLogic()
    {
        doIntroduce();
        boolean isRepeat = false;
        do
        {
            try
            {
                doAction();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("User error: " + e.getMessage());
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("User error: queue is empty\n");
            }
            catch (Exception e)
            {
                System.out.println("System error: " + e.getMessage());
            }
            isRepeat = doRepeat();
        }
        while (isRepeat);
    }

    private static void doIntroduce()
    {
        System.out.println(
            "This is project for demonstration adapter pattern\nThis program works with java.util.List collections through pop() and push() methods\n");
    }

    private static void doAction()
    {
        System.out.println("Please, select action:");
        int choiseNum = doSelectOption(lifoActions);
        executeAction(choiseNum);
    }

    private static boolean doRepeat()
    {
        System.out.println("Continue?");
        int choise = doSelectOption(repeatArr);
        return choise == 1;
    }

    private static double readElement()
    {
        System.out.println("Please, enter double element for pushing:");
        if (inputScan.hasNextDouble())
        {
            double value = inputScan.nextDouble();
            return value;
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
        System.out.println("Enter selected Number:");
        if (inputScan.hasNextInt())
        {
            return inputScan.nextInt();
        }
        return -1;
    }

    private static void executeAction(int choiseNum)
    {
        switch (choiseNum)
        {
            case 1:
                popElement();
                break;
            case 2:
                pushElement();
                break;
            default:
                throw new IllegalArgumentException("Incorrect shape number");
        }
    }

    private static void pushElement()
    {
        Double element = readElement();
        queueAdapter.push(element);
    }

    private static void popElement()
    {
        Double element = queueAdapter.pop();
        System.out.println(String.format("pop element: %s%n", element));
    }

}

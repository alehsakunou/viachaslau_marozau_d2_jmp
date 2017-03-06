import com.epam.jmp.abstractfactory.beans.Person;
import com.epam.jmp.abstractfactory.impl.CachePersonAbstractFactoryImpl;
import com.epam.jmp.abstractfactory.impl.FilePersonAbstractFactoryImpl;
import com.epam.jmp.abstractfactory.interfaces.PersonAbstractFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Viachaslau_Marozau on 3/6/2017.
 */
public class Runner
{
    private static Scanner inputScan;
    private static String[] factoryArr;
    private static String[] actionArr;
    private static String[] repeatArr;
    private static String defFileName;
    private static PersonAbstractFactory factory;

    public static void main(String... args)
    {
        init();
        doApplicationLogic();
    }

    private static void init()
    {
        inputScan = new Scanner(System.in);
        factoryArr = new String[] {"use cache", "use file"};
        actionArr = new String[] {"add person", "get all persons", "get person"};
        repeatArr = new String[] {"Yes", "No"};
        defFileName = "resources\\Persons.data";
    }

    private static void doApplicationLogic()
    {
        doIntroduce();
        try
        {
            factory = doCheckFactory();
            boolean isRepeat = false;
            do
            {
                doCheckAndExecuteAction();
                isRepeat = doRepeat();
            }
            while (isRepeat);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("User error: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("System error: " + e.getMessage());
        }
    }

    private static PersonAbstractFactory doCheckFactory() throws IOException
    {
        System.out.println("Please, select factory:");
        int selectNum = doSelectOption(factoryArr);
        return selectFactory(selectNum);
    }

    private static PersonAbstractFactory selectFactory(int choiseNum) throws IOException
    {
        switch (choiseNum)
        {
            case 1:
                return createCachePersonAbstractFactory();
            case 2:
                return createFilePersonAbstractFactoryImpl();
            default:
                throw new IllegalArgumentException("Incorrect factory number");
        }
    }

    private static PersonAbstractFactory createFilePersonAbstractFactoryImpl() throws IOException
    {
        String fileName = readParam("file name:\n(you can use file " + defFileName + ")");
        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("File not found...\n");
            file.createNewFile();
            System.out.println("File created...\n");
        }
        return new FilePersonAbstractFactoryImpl(file);
    }

    private static PersonAbstractFactory createCachePersonAbstractFactory()
    {
        return new CachePersonAbstractFactoryImpl();
    }

    private static void doIntroduce()
    {
        System.out.println("This project is demo for abstract factory pattern\n");
    }

    private static void doCheckAndExecuteAction()
    {
        System.out.println("Please, select action:");
        int choiseNum = doSelectOption(actionArr);
        executeAction(choiseNum);
    }

    private static boolean doRepeat()
    {
        System.out.println("Continue?");
        int choise = doSelectOption(repeatArr);
        return choise == 1;
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
                addPesson();
                break;
            case 2:
                getAllPersons();
                break;
            case 3:
                getPerson();
                break;
            default:
                throw new IllegalArgumentException("Incorrect action number");
        }
    }

    private static void addPesson()
    {
        String firstName = readParam("first name");
        String lastName = readParam("last name");
        int age = Integer.parseInt(readParam("age"));
        factory.writePerson(new Person(firstName, lastName, age));
        System.out.println("Person added\n");
    }

    private static void getAllPersons()
    {
        for (Person person : factory.readPersons())
        {
            System.out.println(person);
        }
        System.out.println();
    }

    private static void getPerson()
    {
        String firstName = readParam("first name");
        String lastName = readParam("last name");
        Person person = factory.readPerson(firstName, lastName);
        if (person == null)
        {
            System.out.println("person not found\n");
        }
        else
        {
            System.out.println(person + "\n");
        }
    }
}

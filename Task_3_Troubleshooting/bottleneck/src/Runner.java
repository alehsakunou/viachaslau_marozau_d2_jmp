import com.epam.jmp.troubleshooting.impl.SimpleAddMessageThread;
import com.epam.jmp.troubleshooting.impl.SimplePrintMessageThread;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class Runner
{
    public static void main(String... args)
    {
        System.out.println("main started");
        for (int i = 0; i < 10; i++)
        {
            Thread addMessageThread = new SimpleAddMessageThread("Thread " + i);
            addMessageThread.start();
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            //ignore exception
        }
        Thread printMessageThread = new SimplePrintMessageThread("Print Message Thread", System.out);
        printMessageThread.start();
        System.out.println("main ended");
    }
}

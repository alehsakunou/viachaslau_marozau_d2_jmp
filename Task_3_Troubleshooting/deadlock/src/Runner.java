import com.epam.jmp.troubleshooting.impl.SimpleReadWriteThread;
import com.epam.jmp.troubleshooting.impl.SimpleReadWriteResourceImpl;
import com.epam.jmp.troubleshooting.interfaces.ReadWriteResource;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class Runner
{
    public static void main(String... args)
    {
        System.out.println("Main started");

        final String firstResourceName = "First Resource";
        final String secondResourceName = "Second Resource";

        ReadWriteResource firstResource = new SimpleReadWriteResourceImpl(firstResourceName, firstResourceName.getBytes());
        ReadWriteResource secondResource = new SimpleReadWriteResourceImpl(secondResourceName, secondResourceName.getBytes());

        final String firstThreadName = "First Thread";
        final String secondThreadName = "Second Thread";

        Thread firstThread = new SimpleReadWriteThread(firstThreadName, firstResource, secondResource);
        Thread secondThread = new SimpleReadWriteThread(secondThreadName, secondResource, firstResource);

        firstThread.start();
        secondThread.start();

        System.out.println("Main ended");
    }

}

import com.epam.jmp.troubleshooting.impl.CommonResource;
import com.epam.jmp.troubleshooting.impl.SimpleRunHandlerThread;
import com.epam.jmp.troubleshooting.impl.SimpleSyncQueueResourceHandlerImpl;
import com.epam.jmp.troubleshooting.interfaces.ResourceHandler;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class Runner
{
    public static void main(String... args)
    {
        System.out.println("Main started");
        final String firstResourceHandlerName = "First Resource Handler";
        ResourceHandler firstResourceHandler = new SimpleSyncQueueResourceHandlerImpl(firstResourceHandlerName, true);
        final String secondResourceHandlerName = "Secont Resource Handler";
        ResourceHandler secondResourceHandler = new SimpleSyncQueueResourceHandlerImpl(secondResourceHandlerName, true);
        final String thirdResourceHandlerName = "Third Resource Handler";
        ResourceHandler thirdResourceHandler = new SimpleSyncQueueResourceHandlerImpl(thirdResourceHandlerName, true);

        CommonResource CommonResource = new CommonResource(firstResourceHandler);

        final String firstThreadName = "First Thread";
        Thread firstThread = new SimpleRunHandlerThread(firstThreadName, firstResourceHandler, CommonResource,
            new ResourceHandler[] {secondResourceHandler, thirdResourceHandler});
        final String secondThreadName = "Second Thread";
        Thread secondThread = new SimpleRunHandlerThread(secondThreadName, secondResourceHandler, CommonResource,
            new ResourceHandler[] {firstResourceHandler, thirdResourceHandler});
        final String thirdThreadName = "Third Thread";
        Thread thirdThread = new SimpleRunHandlerThread(thirdThreadName, thirdResourceHandler, CommonResource,
            new ResourceHandler[] {firstResourceHandler, secondResourceHandler});

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        System.out.println("Main ended");
    }
}

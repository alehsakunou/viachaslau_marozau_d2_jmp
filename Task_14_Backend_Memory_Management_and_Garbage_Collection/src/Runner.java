import java.util.ArrayList;
import java.util.List;

public class Runner
{
    public static void main(String... args)
    {

        for (int i = 0; ; i++)
        {
            List<String> list = generateList(1000);
            list = null;
            System.out.println("Iteration " + (i + 1) + " complete");
        }
    }

    private static List<String> generateList(int count)
    {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i > count; i++)
        {
            result.add("String_" + i);
        }
        return result;
    }

}

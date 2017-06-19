import com.epam.jmp.threads.beans.Car;

import java.util.ArrayList;
import java.util.List;

public class Runner
{
    private static List<Car> cars = new ArrayList<Car>();

    public static void main(String... args)
    {
        final int numOfCars = 10;

        try
        {
            generateCars(numOfCars);
            Thread.sleep(50000);
            disqualifyCar(numOfCars);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void generateCars(int numOfCars)
    {
        for (int i=0;i<numOfCars;i++){
            long friction = 500L + (long)(Math.random() * 1000);
            Car car = new Car("Car_" + i, friction);
            cars.add(car);
            car.start();
        }
    }


    private static void disqualifyCar(int numOfCars)
    {
        int carNum = (int)(Math.random() * numOfCars);
        cars.get(carNum).interrupt();
    }
}

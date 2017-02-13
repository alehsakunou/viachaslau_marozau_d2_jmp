import com.epam.jmp.shape.implementations.CircularCone;
import com.epam.jmp.shape.implementations.CircularCylinder;
import com.epam.jmp.shape.implementations.ConicalFrustum;
import com.epam.jmp.shape.implementations.Cube;
import com.epam.jmp.shape.implementations.RectangularPrism;
import com.epam.jmp.shape.implementations.Sphere;
import com.epam.jmp.shape.implementations.SquarePyramid;
import com.epam.jmp.shape.interfaces.Shape;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Viachaslau_Marozau on 2/12/2017.
 */
public class Runner
{
    private static Scanner inputScan;
    private static String[] shapeArr;
    private static String[] repeatArr;

    public static void main(String... args)
    {
        init();
        doApplicationLogic();
    }

    private static void init()
    {
        inputScan = new Scanner(System.in);
        shapeArr = new String[] {"Cube", "Rectangular Prism", "Square Pyramid", "Sphere", "Circular Cylinder", "Circular Cone",
            "Conical Frustum"};
        repeatArr = new String[] {"Yes", "No"};
    }

    private static void doApplicationLogic()
    {
        doIntroduce();
        boolean isRepeat = false;
        do
        {
            try
            {

                Shape shape = doCheckShape();
                doCalculateAndPrint(shape);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("User error: " + e.getMessage());
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
        System.out.println("This is first JVM task\nThere used next development principles: DRY, JAGNY, SOLID, KISS");
    }

    private static Shape doCheckShape()
    {
        System.out.println("Please, select shape type:");
        int choiseNum = doSelectOption(shapeArr);
        return getChoisedFigure(choiseNum);
    }

    private static void doCalculateAndPrint(Shape shape)
    {
        System.out.println("Volume : " + shape.calculateVolume());
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
            double value = inputScan.nextDouble();
            verify(value, paramName);
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

    private static Shape getChoisedFigure(int choiseNum)
    {
        switch (choiseNum)
        {
            case 1:
                return createCube();
            case 2:
                return createRectangularPrism();
            case 3:
                return createSquarePyramid();
            case 4:
                return createSphere();
            case 5:
                return createCircularCylinder();
            case 6:
                return createCircularCone();
            case 7:
                return createConicalFrustum();
            default:
                throw new IllegalArgumentException("Incorrect shape number");
        }

    }

    private static void verify(double value, String paramName)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("Nefative value: " + paramName);
        }
    }

    private static Shape createCube()
    {
        double side = readParam("side");
        return new Cube(side);
    }

    private static Shape createRectangularPrism()
    {
        double length = readParam("length");
        double width = readParam("width");
        double height = readParam("height");
        return new RectangularPrism(length, width, height);
    }

    private static Shape createSquarePyramid()
    {
        double side = readParam("side");
        double height = readParam("height");
        return new SquarePyramid(side, height);
    }

    private static Shape createSphere()
    {
        double radius = readParam("radius");
        return new Sphere(radius);
    }

    private static Shape createConicalFrustum()
    {
        double height = readParam("height");
        double firstRadius = readParam("firstRadius");
        double secondRadius = readParam("secondRadius");
        return new ConicalFrustum(height, firstRadius, secondRadius);
    }

    private static Shape createCircularCylinder()
    {
        double height = readParam("height");
        double radius = readParam("radius");
        return new CircularCylinder(height, radius);
    }

    private static Shape createCircularCone()
    {
        double height = readParam("height");
        double radius = readParam("radius");
        return new CircularCone(height, radius);
    }
}


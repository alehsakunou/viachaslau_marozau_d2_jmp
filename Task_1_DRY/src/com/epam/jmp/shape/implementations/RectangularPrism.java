package com.epam.jmp.shape.implementations;

import com.epam.jmp.shape.interfaces.Shape;

/**
 * Created by Viachaslau_Marozau on 2/13/2017.
 */
public class RectangularPrism implements Shape
{
    private final double length;
    private final double width;
    private final double height;

    public RectangularPrism()
    {
        this.length = 0d;
        this.width = 0d;
        this.height = 0d;
    }

    public RectangularPrism(double length, double width, double height)
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    @Override
    public double calculateVolume()
    {
        return length * width * height;
    }
}

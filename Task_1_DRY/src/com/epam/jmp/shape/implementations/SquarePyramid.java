package com.epam.jmp.shape.implementations;

import com.epam.jmp.shape.interfaces.Shape;

/**
 * Created by Viachaslau_Marozau on 2/13/2017.
 */
public class SquarePyramid implements Shape
{
    private final double side;
    private final double height;

    public SquarePyramid()
    {
        this.side = 0d;
        this.height = 0d;
    }

    public SquarePyramid(double side, double height)
    {
        this.side = side;
        this.height = height;
    }

    public double getSide()
    {
        return side;
    }

    public double getHeight()
    {
        return height;
    }

    @Override
    public double calculateVolume()
    {
        return  Math.PI * side * side * height / 3;
    }
}

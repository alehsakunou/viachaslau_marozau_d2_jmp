package com.epam.jmp.shape.implementations;

import com.epam.jmp.shape.interfaces.Shape;

/**
 * Created by Viachaslau_Marozau on 2/12/2017.
 */
public class Cube implements Shape
{
    private final double side;

    public Cube()
    {
        this.side = 0d;
    }

    public Cube(double side)
    {
        this.side = side;
    }

    public double getSide()
    {
        return side;
    }

    @Override
    public double calculateVolume()
    {
        return side * side * side;
    }
}

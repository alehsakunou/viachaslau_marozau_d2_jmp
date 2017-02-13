package com.epam.jmp.shape.implementations;

import com.epam.jmp.shape.interfaces.Shape;

/**
 * Created by Viachaslau_Marozau on 2/12/2017.
 */
public class CircularCylinder implements Shape
{
    private final double height;
    private final double radius;

    public CircularCylinder()
    {
        this.height = 0d;
        this.radius = 0d;
    }

    public CircularCylinder(double height, double radius)
    {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight()
    {
        return height;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public double calculateVolume()
    {
        return Math.PI * radius * radius * height;
    }
}
package com.epam.jmp.shape.implementations;

import com.epam.jmp.shape.interfaces.Shape;

/**
 * Created by Viachaslau_Marozau on 2/13/2017.
 */
public class Sphere implements Shape
{
    private final double radius;

    public Sphere()
    {
        this.radius = 0d;
    }

    public Sphere(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public double calculateVolume()
    {
        return 4 * Math.PI * radius * radius * radius / 3;
    }
}
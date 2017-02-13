package com.epam.jmp.shape.implementations;

import com.epam.jmp.shape.interfaces.Shape;

/**
 * Created by Viachaslau_Marozau on 2/13/2017.
 */
public class ConicalFrustum implements Shape
{
    private final double height;
    private final double firstRadius;
    private final double secondRadius;

    public ConicalFrustum()
    {
        this.height = 0d;
        this.firstRadius = 0d;
        this.secondRadius = 0d;
    }

    public ConicalFrustum(double height, double firstRadius, double secondRadius)
    {
        this.height = height;
        this.firstRadius = firstRadius;
        this.secondRadius = secondRadius;
    }

    public double getHeight()
    {
        return height;
    }

    public double getFirstRadius()
    {
        return firstRadius;
    }

    public double getSecondRadius()
    {
        return secondRadius;
    }

    @Override
    public double calculateVolume()
    {
        double defRadius = firstRadius * firstRadius + secondRadius * secondRadius + firstRadius * secondRadius;
        return Math.PI * defRadius * height / 3;
    }
}
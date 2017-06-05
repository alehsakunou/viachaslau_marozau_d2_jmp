package com.epam.jmp.lambdas.beans;

public class Point
{
    private final int x;
    private final int y;

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Point))
            return false;

        Point point = (Point) o;

        if (getX() != point.getX())
            return false;
        return getY() == point.getY();
    }

    @Override
    public int hashCode()
    {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    @Override
    public String toString()
    {
        return "(" + x + ";" + y + ")";
    }
}

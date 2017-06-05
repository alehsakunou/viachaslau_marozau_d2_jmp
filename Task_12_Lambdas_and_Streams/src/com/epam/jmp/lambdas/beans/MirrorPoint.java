package com.epam.jmp.lambdas.beans;

public class MirrorPoint
{
    private final int x;
    private final int y;

    public MirrorPoint()
    {
        this.x = 0;
        this.y = 0;
    }

    public MirrorPoint(Point point)
    {
        this.x = point.getY();
        this.y = point.getX();
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
        if (!(o instanceof MirrorPoint))
            return false;

        MirrorPoint that = (MirrorPoint) o;

        if (getX() != that.getX())
            return false;
        return getY() == that.getY();
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

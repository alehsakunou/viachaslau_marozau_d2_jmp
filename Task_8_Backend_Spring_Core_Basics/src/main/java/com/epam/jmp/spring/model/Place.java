package com.epam.jmp.spring.model;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */
public class Place
{
    private int number;
    private String row;

    public Place()
    {
        super();
    }

    public Place(int number, String row)
    {
        this.number = number;
        this.row = row;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getRow()
    {
        return row;
    }

    public void setRow(String row)
    {
        this.row = row;
    }
}

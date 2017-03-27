package com.epam.jmp.spring.model;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */
public class Customer
{
    private String firstName;
    private String lastName;

    public Customer()
    {
        super();
    }

    public Customer(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}

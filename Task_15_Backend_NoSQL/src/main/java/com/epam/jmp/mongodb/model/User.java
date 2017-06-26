package com.epam.jmp.mongodb.model;

import java.sql.Date;

public class User
{
    private long id;
    private String name;
    private String surname;
    private Date birthdate;

    public User()
    {
        super();
    }

    public User(long id, String name, String surname, Date birthdate)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surnam)
    {
        this.surname = surnam;
    }

    public Date getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }
}

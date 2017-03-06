package com.epam.jmp.abstractfactory.beans;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public class Person
{
    private String firstName;
    private String lastName;
    private int age;

    public Person()
    {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    public Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;

        if (age != person.age)
            return false;
        if (!firstName.equals(person.firstName))
            return false;
        return lastName.equals(person.lastName);
    }

    @Override
    public int hashCode()
    {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString()
    {
        return firstName + ';' + lastName + ';' + age;
    }
}

package com.epam.jmp.abstractfactory.impl;

import com.epam.jmp.abstractfactory.beans.Person;
import com.epam.jmp.abstractfactory.interfaces.PersonAbstractFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public class CachePersonAbstractFactoryImpl implements PersonAbstractFactory
{
    private Set<Person> cache;

    public CachePersonAbstractFactoryImpl()
    {
        this.cache = new HashSet<Person>();
    }

    public CachePersonAbstractFactoryImpl(Set cache)
    {
        this.cache = cache;
    }

    @Override
    public void writePerson(Person person)
    {
        cache.add(person);
    }

    @Override
    public Person[] readPersons()
    {
        return cache.toArray(new Person[0]);
    }

    @Override
    public Person readPerson(String firstName, String lastName)
    {
        for (Person person : cache)
        {
            String personFirstName = person.getFirstName();
            String personLastName = person.getLastName();
            if (personFirstName.equalsIgnoreCase(firstName) && personLastName.equalsIgnoreCase(lastName))
            {
                return person;
            }
        }
        return null;
    }
}

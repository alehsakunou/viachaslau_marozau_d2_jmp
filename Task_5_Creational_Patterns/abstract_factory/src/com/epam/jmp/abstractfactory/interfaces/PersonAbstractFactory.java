package com.epam.jmp.abstractfactory.interfaces;

    import com.epam.jmp.abstractfactory.beans.Person;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public interface PersonAbstractFactory
{

    void writePerson(Person person);

    Person[] readPersons();

    Person readPerson(String firstName, String lastName);

}

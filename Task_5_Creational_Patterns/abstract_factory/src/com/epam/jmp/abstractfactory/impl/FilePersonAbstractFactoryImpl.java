package com.epam.jmp.abstractfactory.impl;

import com.epam.jmp.abstractfactory.beans.Person;
import com.epam.jmp.abstractfactory.interfaces.PersonAbstractFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Viachaslau_Marozau on 3/5/2017.
 */
public class FilePersonAbstractFactoryImpl implements PersonAbstractFactory
{

    private File file;

    public FilePersonAbstractFactoryImpl(File file)
    {
        this.file = file;
    }

    public FilePersonAbstractFactoryImpl(String fileName)
    {
        this.file = new File(fileName);
    }

    @Override
    public void writePerson(Person person)
    {
        Set<Person> persons = new HashSet<Person>();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try
        {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append(person.getFirstName()).append(";").append(person.getLastName()).append(";").append(person.getAge())
                .append("\n");
            bufferedWriter.write(lineBuilder.toString());
            bufferedWriter.flush();
        }
        catch (Exception e)
        {
            //do nothing
        }
        finally
        {
            try
            {
                bufferedWriter.close();
                fileWriter.close();
            }
            catch (IOException e)
            {
                //do nothing
            }
        }

    }

    @Override
    public Person[] readPersons()
    {
        Set<Person> persons = new HashSet<Person>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                Person person = pasteLine(line);
                persons.add(person);
            }
        }
        catch (Exception e)
        {
            //do nothing
        }
        finally
        {
            try
            {
                bufferedReader.close();
                fileReader.close();
            }
            catch (IOException e)
            {
                //do nothing
            }
        }
        return persons.toArray(new Person[0]);
    }

    @Override
    public Person readPerson(String firstName, String lastName)
    {
        Set<Person> persons = new HashSet<Person>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                Person person = pasteLine(line);
                String personFirstName = person.getFirstName();
                String personLastName = person.getLastName();
                if (personFirstName.equalsIgnoreCase(firstName) && personLastName.equalsIgnoreCase(lastName))
                {
                    return person;
                }
            }
        }
        catch (Exception e)
        {
            //do nothing
        }
        finally
        {
            try
            {
                bufferedReader.close();
                fileReader.close();
            }
            catch (IOException e)
            {
                //do nothing
            }
        }
        return new Person();
    }

    private Person pasteLine(String line)
    {
        String[] data = line.split(";");
        String firstName = data[0];
        String lastName = data[1];
        int age = Integer.parseInt(data[2]);
        return new Person(firstName, lastName, age);
    }
}

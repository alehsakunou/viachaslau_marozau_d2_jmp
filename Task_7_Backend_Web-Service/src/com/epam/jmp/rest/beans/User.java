package com.epam.jmp.rest.beans;

/**
 * Created by Viachaslau_Marozau on 3/18/2017.
 */
public class User
{
    private String login;
    private String password;

    public User()
    {
        this.login = "";
        this.password = "";
    }

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}

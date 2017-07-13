package com.epam.jmp.spring.dao.impl;

import com.epam.jmp.spring.dao.interfaces.UserDAO;
import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;

import java.sql.Timestamp;

public class PostgreSQLUserDAOImpl implements UserDAO
{
    @Override
    public User addUser(String login, String password, Role role, long userInfoId)
    {
        return null;
    }

    @Override
    public UserInfo addUserInfo(String name, String surname, String email, String phone, Timestamp birthdate)
    {
        return null;
    }

    @Override
    public User getUser(String login, String password)
    {
        return null;
    }

    @Override
    public UserInfo getUserInfo(User user)
    {
        return null;
    }

    @Override
    public User removeUser(String login, String password)
    {
        return null;
    }
}

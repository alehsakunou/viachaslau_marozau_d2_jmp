package com.epam.jmp.spring.service.impl;

import com.epam.jmp.spring.dao.interfaces.UserDAO;
import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;
import com.epam.jmp.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO userDAO;

    @Override
    public User addUser(String login, String password, Role role, long userInfoId)
    {
        return userDAO.addUser(login, password, role, userInfoId);
    }

    @Override
    public UserInfo addUserInfo(String name, String surname, String email, String phone, Timestamp birthdate)
    {
        return userDAO.addUserInfo(name, surname, email, phone, birthdate);
    }

    @Override
    public User getUser(String login, String password)
    {
        return userDAO.getUser(login, password);
    }

    @Override
    public UserInfo getUserInfo(User user)
    {
        return userDAO.getUserInfo(user);
    }

    @Override
    public User removeUser(String login, String password)
    {
        return userDAO.removeUser(login, password);
    }
}

package com.epam.jmp.spring.service.impl;

import com.epam.jmp.spring.repositories.interfaces.UserRepository;
import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;
import com.epam.jmp.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(String login, String password, Role role, long userInfoId)
    {
        return userRepository.addUser(login, password, role, userInfoId);
    }

    @Override
    public UserInfo addUserInfo(String name, String surname, String email, String phone, Timestamp birthdate)
    {
        return userRepository.addUserInfo(name, surname, email, phone, birthdate);
    }

    @Override
    public User getUser(String login, String password)
    {
        return userRepository.getUser(login, password);
    }

    @Override
    public UserInfo getUserInfo(User user)
    {
        return userRepository.getUserInfo(user);
    }

    @Override
    public void removeUser(String login, String password)
    {
        userRepository.removeUser(login, password);
    }
}

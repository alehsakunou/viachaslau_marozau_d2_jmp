package com.epam.jmp.spring.service.impl;

import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;

import java.sql.Timestamp;

public class UserServiceImpl
{
    User addUser(String login, String password, Role role, long userInfoId);
    {
        return null;
    }
    UserInfo addUserInfo (String name, String surname, String email,
        String phone, Timestamp birthdate)
    {
        return null;
    }
}

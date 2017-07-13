package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;

import java.sql.Timestamp;

public interface UserDAO
{
    User addUser(String login, String password, Role role, long userInfoId);

    UserInfo addUserInfo (String name, String surname, String email, String phone, Timestamp birthdate);

    User getUser (String login, String password);

    UserInfo getUserInfo(User user);

    User removeUser (String login, String password);

}

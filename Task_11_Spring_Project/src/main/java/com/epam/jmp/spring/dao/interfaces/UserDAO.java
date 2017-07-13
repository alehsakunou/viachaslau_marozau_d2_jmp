package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;

public interface UserDAO
{
    User addUser(String login, String password, Role role, long userInfoId);
}

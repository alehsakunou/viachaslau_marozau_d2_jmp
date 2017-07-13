package com.epam.jmp.spring.service.interfaces;

import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;

import java.sql.Timestamp;

public interface UserService
{
    User addUser(String login, String password, Role role, String name, String surname, String email,
        String phone, Timestamp birthdate);
}

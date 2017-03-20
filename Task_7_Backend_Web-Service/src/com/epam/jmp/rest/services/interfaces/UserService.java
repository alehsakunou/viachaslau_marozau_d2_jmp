package com.epam.jmp.rest.services.interfaces;

import com.epam.jmp.rest.beans.User;

import java.util.List;

/**
 * Created by Viachaslau_Marozau on 3/18/2017.
 */
public interface UserService
{
    User add(User user);

    User update(User user);

    User delete(String login);

    List<User> getAllUsers();

    User getUser(String login);
}

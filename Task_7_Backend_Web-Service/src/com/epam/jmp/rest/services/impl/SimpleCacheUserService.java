package com.epam.jmp.rest.services.impl;

import com.epam.jmp.rest.beans.User;
import com.epam.jmp.rest.services.interfaces.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Viachaslau_Marozau on 3/18/2017.
 */
public class SimpleCacheUserService implements UserService
{
    private final static Map<String, User> userCache = new HashMap<String, User>();

    @Override
    public User add(User user)
    {
        return userCache.put(user.getLogin(), user);
    }

    @Override
    public User update(User user)
    {
        return userCache.put(user.getLogin(), user);
    }

    @Override
    public User delete(String login)
    {
        return userCache.remove(login);
    }

    @Override
    public List<User> getAllUsers()
    {
        List<User> result = new ArrayList<User>();
        for (User user : userCache.values())
        {
            result.add(user);
        }
        return result;
    }

    @Override
    public User getUser(String login)
    {
        return userCache.get(login);
    }
}

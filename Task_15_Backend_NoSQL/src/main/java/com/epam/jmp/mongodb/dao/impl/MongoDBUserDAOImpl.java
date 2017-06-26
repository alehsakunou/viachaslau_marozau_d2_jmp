package com.epam.jmp.mongodb.dao.impl;

import com.epam.jmp.mongodb.dao.interfaces.UserDAO;
import com.epam.jmp.mongodb.model.User;
import com.mongodb.MongoClient;

public class MongoDBUserDAOImpl implements UserDAO
{
    private MongoClient mongoClient;

    public void setDataSource(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }

    @Override
    public void addUser(User user)
    {

    }

    @Override
    public User removeUser(User user)
    {
        //TODO
        return null;
    }

    @Override
    public User[] getUsers()
    {
        //TODO
        return new User[0];
    }

    @Override
    public User getUserById(long id)
    {
        //TODO
        return null;
    }

    @Override
    public User getUserByName(String name, String surname)
    {
        return null;
    }

    @Override
    public User[] getUsersByFriendsAndLikesCount(int friendshipNum, int likeNum)
    {
        return null;
    }
}

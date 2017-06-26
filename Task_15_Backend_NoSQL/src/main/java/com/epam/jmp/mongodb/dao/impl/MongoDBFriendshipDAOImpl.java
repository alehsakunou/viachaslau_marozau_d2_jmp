package com.epam.jmp.mongodb.dao.impl;

import com.epam.jmp.mongodb.dao.interfaces.FriendshipDAO;
import com.epam.jmp.mongodb.model.Friendship;
import com.mongodb.MongoClient;

public class MongoDBFriendshipDAOImpl implements FriendshipDAO
{

    private MongoClient mongoClient;

    public void setDataSource(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }

    @Override
    public void addFriendship(Friendship friendship)
    {
        mongoClient.getDatabase("");

    }

    @Override
    public Friendship removeFriendship(Friendship friendship)
    {
        //TODO
        return null;
    }

    @Override
    public Friendship[] getFriendships()
    {
        //TODO
        return new Friendship[0];
    }

    @Override
    public Friendship getFriendshipById(long id)
    {
        //TODO
        return null;
    }

    @Override
    public Friendship[] getFriendshipByUserId(long userId)
    {
        //TODO
        return new Friendship[0];
    }
}

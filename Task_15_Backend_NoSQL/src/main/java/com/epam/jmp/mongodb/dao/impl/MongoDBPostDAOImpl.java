package com.epam.jmp.mongodb.dao.impl;

import com.epam.jmp.mongodb.dao.interfaces.PostDAO;
import com.epam.jmp.mongodb.model.Post;
import com.mongodb.MongoClient;


public class MongoDBPostDAOImpl implements PostDAO
{
    private MongoClient mongoClient;

    public void setDataSource(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }

    @Override
    public void addPost(Post post)
    {

    }

    @Override
    public Post removePost(Post postost)
    {
        //TODO
        return null;
    }

    @Override
    public Post[] getPosts()
    {
        //TODO
        return new Post[0];
    }

    @Override
    public Post getPostById(long id)
    {
        //TODO
        return null;
    }

    @Override
    public Post[] getPostByUserId(long userId)
    {
        //TODO
        return new Post[0];
    }
}

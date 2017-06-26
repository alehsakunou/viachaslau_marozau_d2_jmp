package com.epam.jmp.mongodb.dao.impl;

import com.epam.jmp.mongodb.dao.interfaces.LikeDAO;
import com.epam.jmp.mongodb.model.Like;
import com.mongodb.MongoClient;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class MongoDBLikeDAOImpl implements LikeDAO
{
    private MongoClient mongoClient;

    public void setDataSource(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }

    @Override
    public void addLike(Like like)
    {

    }

    @Override
    public Like removeLike(Like like)
    {
        //TODO
        return null;
    }

    @Override
    public Like[] getLikes()
    {
        //TODO
        return new Like[0];
    }

    @Override
    public Like getLikeById(long id)
    {
        //TODO
        return null;
    }

    @Override
    public Like[] getLikeByUserId(long userId)
    {
        //TODO
        return new Like[0];
    }
}

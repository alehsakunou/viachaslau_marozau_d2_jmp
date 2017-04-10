package com.epam.jmp.spring.dao.impl;

import com.epam.jmp.spring.dao.interfaces.LikeDAO;
import com.epam.jmp.spring.model.Like;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Viachaslau_Marozau on 4/4/2017.
 */
public class SQLiteLikeDAOImpl implements LikeDAO
{
    private JdbcTemplate jdbsTemplate;

    public void setDataSource(DataSource dataSource)
    {
        jdbsTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addLike(Like like)
    {
        String sql = "INSERT INTO likes (postid, userid, timestamp) VALUES (?, ?, ?)";
        jdbsTemplate.update(sql, like.getPostId(), like.getUserId(), like.getTimestamp());
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

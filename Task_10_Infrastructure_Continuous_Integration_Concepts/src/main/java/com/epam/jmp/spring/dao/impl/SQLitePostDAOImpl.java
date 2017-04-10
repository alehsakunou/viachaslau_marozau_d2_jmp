package com.epam.jmp.spring.dao.impl;

import com.epam.jmp.spring.dao.interfaces.PostDAO;
import com.epam.jmp.spring.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Viachaslau_Marozau on 4/4/2017.
 */
public class SQLitePostDAOImpl implements PostDAO
{
    private JdbcTemplate jdbsTemplate;

    public void setDataSource(DataSource dataSource)
    {
        jdbsTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addPost(Post post)
    {
        String sql = "INSERT INTO posts (userId, text, timestamp) VALUES (?, ?, ?)";
        jdbsTemplate.update(sql, post.getUserId(), post.getText(), post.getTimestamp());
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

package com.epam.jmp.spring.dao.impl;

import com.epam.jmp.spring.dao.interfaces.FriendshipDAO;
import com.epam.jmp.spring.model.Friendship;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Viachaslau_Marozau on 4/4/2017.
 */
public class SQLiteFriendshipDAOImpl implements FriendshipDAO
{

    private JdbcTemplate jdbsTemplate;

    public void setDataSource(DataSource dataSource)
    {
        jdbsTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addFriendship(Friendship friendship)
    {
        String sql = "INSERT INTO friendships (userid1, userid2, timestamp) VALUES (?, ?, ?)";
        jdbsTemplate.update(sql, friendship.getUserId1(), friendship.getUserId2(), friendship.getTimestamp());
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

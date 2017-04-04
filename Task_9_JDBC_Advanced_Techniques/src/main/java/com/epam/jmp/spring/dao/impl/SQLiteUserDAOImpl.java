package com.epam.jmp.spring.dao.impl;

import com.epam.jmp.spring.dao.interfaces.UserDAO;
import com.epam.jmp.spring.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public class SQLiteUserDAOImpl implements UserDAO
{
    private JdbcTemplate jdbsTemplate;

    public void setDataSource(DataSource dataSource)
    {
        jdbsTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user)
    {
        String sql = "INSERT INTO users (name, surname, birthdate) VALUES (?, ?, ?)";
        jdbsTemplate.update(sql, user.getName(), user.getSurname(), user.getBirthdate());
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
        String sql = "SELECT * FROM users WHERE name=? AND surname=?";
        return jdbsTemplate.queryForObject(sql, new UserRowMapper(), name, surname);
    }

    @Override
    public User[] getUsersByFriendsAndLikesCount(int friendshipNum, int likeNum)
    {
        String sql = "SELECT *\n" +
            "FROM users\n" +
            "WHERE users.id IN\n" +
            "(SELECT friendships.userId1\n" +
            "FROM friendships\n" +
            "WHERE (\n" +
            "SELECT count(*)\n" +
            "FROM friendships\n" +
            "GROUP BY friendships.userId1)>?\n" +
            "UNION\n" +
            "SELECT friendships.userId2\n" +
            "FROM friendships\n" +
            "WHERE  (\n" +
            "SELECT count(*)\n" +
            "FROM friendships\n" +
            "GROUP BY friendships.userId2)>?)\n" +
            "AND\n" +
            "users.id IN\n" +
            "(SELECT likes.userId\n" +
            "FROM likes\n" +
            "WHERE (\n" +
            "SELECT count(*)\n" +
            "FROM likes\n" +
            "GROUP BY likes.userId)>?)";
        List<User> users = jdbsTemplate.query(sql, new UserRowMapper(), friendshipNum, friendshipNum, likeNum);
        return users.toArray(new User[0]);
    }

    private static final class UserRowMapper implements RowMapper<User>
    {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setBirthdate(rs.getDate("birthdate"));
            return user;
        }
    }
}

package com.epam.jmp.spring.dao.impl;

import com.epam.jmp.spring.dao.interfaces.TableDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public class SQLiteTableDAOImpl implements TableDAO
{
    private JdbcTemplate jdbsTemplate;

    public void setDataSource(DataSource dataSource)
    {
        jdbsTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean dropTables()
    {
        String usersRemoveSql = "DROP TABLE IF EXISTS users";
        String friendshipsRemoveSql = "DROP TABLE IF EXISTS friendships";
        String postsRemoveSql = "DROP TABLE IF EXISTS posts";
        String likesRemoveSql = "DROP TABLE IF EXISTS likes";

        jdbsTemplate.execute(likesRemoveSql);
        jdbsTemplate.execute(postsRemoveSql);
        jdbsTemplate.execute(friendshipsRemoveSql);
        jdbsTemplate.execute(usersRemoveSql);

        return true;
    }

    @Override
    public boolean createTables()
    {
        String usersCreateSql = "CREATE TABLE IF NOT EXISTS users (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "name TEXT," +
            "surname TEXT," +
            "birthdate DATE)";

        String friendshipsCreateSql = "CREATE TABLE IF NOT EXISTS friendships (" +
            "userid1 INTEGER," +
            "userid2 INTEGER," +
            "timestamp DATE)";

        String postsCreateSql = "CREATE TABLE IF NOT EXISTS posts (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "userId INTEGER, " +
            "text TEXT, " +
            "timestamp DATE)";

        String likesCreateSql = "CREATE TABLE IF NOT EXISTS likes (" +
            "postid INTEGER, " +
            "userid INTEGER, " +
            "timestamp DATE)";

        jdbsTemplate.execute(usersCreateSql);
        jdbsTemplate.execute(friendshipsCreateSql);
        jdbsTemplate.execute(postsCreateSql);
        jdbsTemplate.execute(likesCreateSql);

        return true;
    }
}

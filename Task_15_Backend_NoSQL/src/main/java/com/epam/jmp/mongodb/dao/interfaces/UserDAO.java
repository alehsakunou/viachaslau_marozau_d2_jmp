package com.epam.jmp.mongodb.dao.interfaces;

import com.epam.jmp.mongodb.model.User;

import java.sql.Date;


public interface UserDAO
{
    void addUser(User user);

    User removeUser(User user);

    User[] getUsers();

    User getUserById(long id);

    User getUserByName(String name, String surname);

    User[] getUsersByFriendsAndLikesCount(int friendshipNum, int likeNum);
}

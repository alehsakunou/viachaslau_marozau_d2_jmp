package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.User;

import java.sql.Date;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public interface UserDAO
{
    void addUser(User user);

    User removeUser(User user);

    User[] getUsers();

    User getUserById(long id);

    User getUserByName(String name, String surname);

    User[] getUsersByFriendsAndLikesCount(int friendshipNum, int likeNum);
}

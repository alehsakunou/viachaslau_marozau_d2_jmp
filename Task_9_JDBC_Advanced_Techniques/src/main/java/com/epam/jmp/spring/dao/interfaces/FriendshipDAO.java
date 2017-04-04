package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.Friendship;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public interface FriendshipDAO
{
    void addFriendship(Friendship friendship);

    Friendship removeFriendship(Friendship friendship);

    Friendship[] getFriendships();

    Friendship getFriendshipById(long id);

    Friendship[] getFriendshipByUserId(long userId);
}

package com.epam.jmp.mongodb.dao.interfaces;

import com.epam.jmp.mongodb.model.Friendship;

public interface FriendshipDAO
{
    void addFriendship(Friendship friendship);

    Friendship removeFriendship(Friendship friendship);

    Friendship[] getFriendships();

    Friendship getFriendshipById(long id);

    Friendship[] getFriendshipByUserId(long userId);
}

package com.epam.jmp.mongodb.service.interfaces;

import com.epam.jmp.mongodb.model.User;

import java.sql.Date;

public interface ManageDatabaseFacadeService
{
    void generateDatabase(int userNum, int friendshipNum, int postNum, int likeNum);

    User[] searchUsersByFriendsAndLices(int friendshipNum, int likeNum);
}

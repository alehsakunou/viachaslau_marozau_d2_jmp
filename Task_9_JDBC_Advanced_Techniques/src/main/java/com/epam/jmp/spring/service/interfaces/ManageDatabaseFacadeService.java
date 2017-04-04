package com.epam.jmp.spring.service.interfaces;

import com.epam.jmp.spring.model.User;

import java.sql.Date;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public interface ManageDatabaseFacadeService
{
    void generateDatabase(int userNum, int friendshipNum, int postNum, int likeNum);

    User[] searchUsersByFriendsAndLices(int friendshipNum, int likeNum);
}

package com.epam.jmp.spring.service.impl;

import com.epam.jmp.spring.dao.interfaces.FriendshipDAO;
import com.epam.jmp.spring.dao.interfaces.LikeDAO;
import com.epam.jmp.spring.dao.interfaces.PostDAO;
import com.epam.jmp.spring.dao.interfaces.TableDAO;
import com.epam.jmp.spring.dao.interfaces.UserDAO;
import com.epam.jmp.spring.model.Friendship;
import com.epam.jmp.spring.model.Like;
import com.epam.jmp.spring.model.Post;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.service.interfaces.ManageDatabaseFacadeService;

import java.sql.Date;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
@SuppressWarnings("ALL")
public class SimpleManageDatabaseFacadeServiceImpl implements ManageDatabaseFacadeService
{

    TableDAO tableDAO;
    UserDAO userDAO;
    FriendshipDAO friendshipDAO;
    PostDAO postDAO;
    LikeDAO likeDAO;

    public SimpleManageDatabaseFacadeServiceImpl()
    {
        super();
    }

    public void setTableDAO(TableDAO tableDAO)
    {
        this.tableDAO = tableDAO;
    }

    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public void setFriendshipDAO(FriendshipDAO friendshipDAO)
    {
        this.friendshipDAO = friendshipDAO;
    }

    public void setPostDAO(PostDAO postDAO)
    {
        this.postDAO = postDAO;
    }

    public void setLikeDAO(LikeDAO likeDAO)
    {
        this.likeDAO = likeDAO;
    }

    @Override
    public void generateDatabase(int userNum, int friendshipNum, int postNum, int likeNum)
    {
        tableDAO.dropTables();
        tableDAO.createTables();
        for (int i = 0; i < userNum; i++)
        {
            userDAO.addUser(generateUser());
        }
        for (int i = 0; i < friendshipNum; i++)
        {
            friendshipDAO.addFriendship(generateFriendship(userNum));
        }
        for (int i = 0; i < userNum; i++)
        {
            postDAO.addPost(generatePost(userNum));
        }
        for (int i = 0; i < likeNum; i++)
        {
            likeDAO.addLike(generateLike(userNum, postNum));
        }
    }

    @Override
    public User[] searchUsersByFriendsAndLices(int friendshipNum, int likeNum)
    {
        return userDAO.getUsersByFriendsAndLikesCount(friendshipNum, likeNum);
    }

    private User generateUser()
    {
        User user = new User();
        user.setName(generateString(generateInt(12)));
        user.setSurname(generateString(generateInt(20)));
        Date dateFrom = new Date(1985, 1, 1);
        Date dateTo = new Date(2005, 1, 1);
        user.setBirthdate(generateDate(dateFrom, dateTo));
        return user;
    }

    private Friendship generateFriendship(int userNum)
    {
        Friendship friendship = new Friendship();
        friendship.setUserId1(generateLong(userNum));
        friendship.setUserId2(generateLong(userNum));
        Date dateFrom = new Date(2015, 1, 1);
        Date dateTo = new Date(2017, 1, 1);
        friendship.setTimestamp(generateDate(dateFrom, dateTo));
        return friendship;
    }

    private Like generateLike(int userNum, int postNum)
    {
        Like like = new Like();
        like.setPostId(generateLong(postNum));
        like.setUserId(generateLong(userNum));
        Date dateFrom = new Date(2015, 1, 1);
        Date dateTo = new Date(2017, 1, 1);
        like.setTimestamp(generateDate(dateFrom, dateTo));
        return like;
    }

    private Post generatePost(int userNum)
    {
        Post post = new Post();
        post.setUserId(generateLong(userNum));
        post.setText(generateString(100));
        Date dateFrom = new Date(2015, 1, 1);
        Date dateTo = new Date(2017, 1, 1);
        post.setTimestamp(generateDate(dateFrom, dateTo));
        return post;
    }

    private Date generateDate(Date fromDate, Date toDate)
    {
        return fromDate;
    }

    private String generateString(int lenght)
    {
        char[] charArr = new char[lenght];
        for (int i = 0; i < lenght; i++)
        {
            charArr[i] = (char) (65 + generateInt(122 - 65));
        }
        return new String(charArr);
    }

    private int generateInt(int maxValue)
    {
        return (int) (maxValue * Math.random());
    }

    private long generateLong(long maxValue)
    {
        return (long) (maxValue * Math.random());
    }
}

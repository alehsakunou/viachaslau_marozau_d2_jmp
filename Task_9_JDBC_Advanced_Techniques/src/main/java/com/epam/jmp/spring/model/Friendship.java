package com.epam.jmp.spring.model;

import java.sql.Date;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public class Friendship
{
    private long userId1;
    private long userId2;
    private Date timestamp;

    public Friendship()
    {
        super();
    }

    public Friendship(long userId1, long userId2, Date timestamp)
    {
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.timestamp = timestamp;
    }

    public long getUserId1()
    {
        return userId1;
    }

    public void setUserId1(long userId1)
    {
        this.userId1 = userId1;
    }

    public long getUserId2()
    {
        return userId2;
    }

    public void setUserId2(long userId2)
    {
        this.userId2 = userId2;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
}

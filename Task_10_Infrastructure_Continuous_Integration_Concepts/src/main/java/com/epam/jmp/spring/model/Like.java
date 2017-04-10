package com.epam.jmp.spring.model;

import java.sql.Date;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public class Like
{
    private long postid;
    private long userid;
    private Date timestamp;

    public Like()
    {
    }

    public Like(long postid, long userid, Date timestamp)
    {
        this.postid = postid;
        this.userid = userid;
        this.timestamp = timestamp;
    }

    public long getPostId()
    {
        return postid;
    }

    public void setPostId(long postid)
    {
        this.postid = postid;
    }

    public long getUserId()
    {
        return userid;
    }

    public void setUserId(long userid)
    {
        this.userid = userid;
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

package com.epam.jmp.spring.model;

import java.sql.Date;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public class Post
{
    private long id;
    private long userId;
    private String text;
    private Date timestamp;

    public Post()
    {
        super();
    }

    public Post(long id, long userId, String text, Date timestamp)
    {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
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

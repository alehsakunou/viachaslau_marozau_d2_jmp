package com.epam.jmp.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "EVENTS")
public class Event
{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "AUDITORIUMID")
    private long auditoriumId;

    @Column(name = "MOVIEID")
    private long movieId;

    @Column(name = "DATE")
    private Timestamp date;

    public Event()
    {
        super();
    }

    public Event(long id, long auditoriumId, long movieId, Timestamp date)
    {
        this.id = id;
        this.auditoriumId = auditoriumId;
        this.movieId = movieId;
        this.date = date;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getAuditoriumId()
    {
        return auditoriumId;
    }

    public void setAuditoriumId(long auditoriumId)
    {
        this.auditoriumId = auditoriumId;
    }

    public long getMovieId()
    {
        return movieId;
    }

    public void setMovieId(long movieId)
    {
        this.movieId = movieId;
    }

    public Timestamp getDate()
    {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }
}

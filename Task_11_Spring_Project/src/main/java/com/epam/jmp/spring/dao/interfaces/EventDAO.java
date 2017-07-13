package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.Event;

import java.sql.Date;
import java.sql.Timestamp;

public interface EventDAO
{
    Event addEvent(long auditoriumId, long movieId, Timestamp date);
    Event[] getEvents (Date fromDate, Date toDate);
}

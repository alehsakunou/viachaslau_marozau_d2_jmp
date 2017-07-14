package com.epam.jmp.spring.repositories.interfaces;

import com.epam.jmp.spring.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Timestamp;

public interface EventRepository extends CrudRepository<Event, Long>
{
    Event addEvent(long auditoriumId, long movieId, Timestamp date);
    Event[] getEvents (Date fromDate, Date toDate);
}

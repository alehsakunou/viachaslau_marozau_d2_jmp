package com.epam.jmp.spring.repositories.interfaces;

import com.epam.jmp.spring.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long>
{
}

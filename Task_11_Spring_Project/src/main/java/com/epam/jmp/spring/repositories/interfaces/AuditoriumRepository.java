package com.epam.jmp.spring.repositories.interfaces;

import com.epam.jmp.spring.model.Auditorium;
import org.springframework.data.repository.CrudRepository;

public interface AuditoriumRepository extends CrudRepository<Auditorium, Long>
{
    Auditorium addAuditorium (Auditorium auditorium);
}

package com.epam.jmp.spring.repositories.interfaces;

import com.epam.jmp.spring.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>
{
}

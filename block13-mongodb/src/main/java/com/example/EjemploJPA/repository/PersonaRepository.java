package com.example.EjemploJPA.repository;

import com.example.EjemploJPA.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, Integer> {
    Persona findById(String id);
}

package com.example.EjemploJPA.repository;

import com.example.EjemploJPA.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByNombre(String nombre);

    Persona deleteById(int id);
}

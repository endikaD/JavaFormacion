package com.example.EjemploJPA.persona.repository;

import com.example.EjemploJPA.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByUsuario(String usuario);
}

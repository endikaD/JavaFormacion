package com.example.EjemploJPA.persona.repository;

import com.example.EjemploJPA.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByEmailPersonal(String emailPersonal);
    Persona findByUsuario(String usuario);
    public List<Persona> getData(HashMap<String, Object> conditions);
}

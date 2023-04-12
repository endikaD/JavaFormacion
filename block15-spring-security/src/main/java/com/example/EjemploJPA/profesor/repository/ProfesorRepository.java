package com.example.EjemploJPA.profesor.repository;

import com.example.EjemploJPA.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}

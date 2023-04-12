package com.example.EjemploJPA.estudiante.repository;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}

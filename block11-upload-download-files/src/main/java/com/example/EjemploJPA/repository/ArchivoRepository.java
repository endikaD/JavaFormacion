package com.example.EjemploJPA.repository;

import com.example.EjemploJPA.domain.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {
    Archivo findFileByNombre(String nombre);
    Archivo findFileByType(String type);
}

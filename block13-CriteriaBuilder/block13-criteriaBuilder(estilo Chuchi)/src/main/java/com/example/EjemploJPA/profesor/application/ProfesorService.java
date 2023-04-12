package com.example.EjemploJPA.profesor.application;

import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.profesor.controller.dto.input.ProfesorInputDto;
import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {

    ProfesorOutputDto añadirProfesor(ProfesorInputDto profesorInputDto) throws Exception;

    ProfesorOutputDto obtenerProfesorPorId(Integer id) throws EntityNotFoundException;

    List<ProfesorOutputDto> obtenerProfesores();

    ProfesorOutputDto actualizarProfesor(Integer id, ProfesorInputDto profesorInputDto) throws Exception;
    void borrarProfesor(Integer id) throws Exception;
}

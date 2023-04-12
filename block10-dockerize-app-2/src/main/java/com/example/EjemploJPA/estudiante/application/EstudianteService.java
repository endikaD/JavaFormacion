package com.example.EjemploJPA.estudiante.application;

import com.example.EjemploJPA.estudiante.controller.dto.input.EstudianteInputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteFullOutputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteOutputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteSimpleOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;

import java.util.List;

public interface EstudianteService {
    EstudianteOutputDto añadirEstudiante(EstudianteInputDto estudianteInputDto) throws Exception;

    EstudianteSimpleOutputDto obtenerEstudianteSimplePorId(Integer id, String outputType) throws EntityNotFoundException;
    EstudianteFullOutputDto obtenerEstudianteFullPorId(Integer id, String outputType) throws EntityNotFoundException;

    List<EstudianteOutputDto> obtenerEstudiantes();

    EstudianteOutputDto actualizarEstudiante(Integer id, EstudianteInputDto estudianteInputDto) throws Exception;
    void borrarEstudiante(Integer id) throws Exception;
}

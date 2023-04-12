package com.example.EjemploJPA.asignatura.application;

import com.example.EjemploJPA.asignatura.controller.dto.input.AsignaturaInputDto;
import com.example.EjemploJPA.asignatura.controller.dto.output.AsignaturaOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;

import java.util.List;

public interface AsignaturaService {
    AsignaturaOutputDto añadirAsignatura(AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException;

    AsignaturaOutputDto obtenerAsignaturaPorId(Integer id) throws EntityNotFoundException;

    List<AsignaturaOutputDto> obtenerAsignaturas();

    AsignaturaOutputDto actualizarAsignatura(Integer id, AsignaturaInputDto asignaturaInputDto) throws Exception;
    void borrarAsignatura(Integer id) throws Exception;
    void añadirAsignaturaAEstudiante(int idAsignatura, int idEstudiante);
}

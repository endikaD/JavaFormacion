package com.example.EjemploJPA.estudiante.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInputDto {
    private Integer idPersona; //
    private Integer idProfesor;
    private Integer horasPorSemana; //
    private String comentarios; //
    private String branch;
    private List <Integer> asignaturas = new ArrayList<>();
}

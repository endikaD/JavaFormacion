package com.example.EjemploJPA.controller.dto.input;

import com.example.EjemploJPA.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {
    private String id;
    private String nombre;
    private String poblacion;
    private Integer edad;

}

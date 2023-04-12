package com.example.EjemploJPA.controller.dto.output;

import com.example.EjemploJPA.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDto {
    private String id;
    private String nombre;
    private String poblacion;
    private Integer edad;

    public PersonaOutputDto(Persona persona){
        setId(persona.getId());
        setNombre(persona.getNombre());
        setPoblacion(persona.getPoblacion());
        setEdad(persona.getEdad());
    }
}

package com.example.EjemploJPA.domain;

import com.example.EjemploJPA.controller.dto.input.PersonaInputDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "personas")
public class Persona {
    @Id
    private String id;
    private String nombre;
    private String poblacion;
    private Integer edad;
    public Persona (PersonaInputDto personaInputDto){
        setId(personaInputDto.getId());
        setNombre(personaInputDto.getNombre());
        setPoblacion(personaInputDto.getPoblacion());
        setEdad(personaInputDto.getEdad());
    }
}

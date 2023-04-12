package com.example.EjemploJPA.domain;

import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.PersonaOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persona {
    @Id
    @GeneratedValue
    int id;
    String nombre;
    String poblacion;
    int edad;

    public Persona(PersonaInputDto personaInputDto) {
        this.id = personaInputDto.getId();
        this.nombre = personaInputDto.getNombre();
        this.poblacion = personaInputDto.getPoblacion();
        this.edad = personaInputDto.getEdad();
    }

    public PersonaOutputDto personaToPersonaOutputDto() {
        return new PersonaOutputDto(
                this.id,
                this.nombre,
                this.poblacion,
                this.edad
        );
    }
}

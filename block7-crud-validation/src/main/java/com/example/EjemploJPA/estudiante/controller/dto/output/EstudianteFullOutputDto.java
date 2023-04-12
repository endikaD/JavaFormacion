package com.example.EjemploJPA.estudiante.controller.dto.output;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteFullOutputDto extends EstudianteSimpleOutputDto{
    private PersonaOutputDto personaOutputDto;

    public EstudianteFullOutputDto(Estudiante estudiante){
        super(estudiante);
        setPersonaOutputDto(new PersonaOutputDto(estudiante.getPersona()));
    }
}

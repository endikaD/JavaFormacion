package com.example.EjemploJPA.profesor.controller.dto.output;

import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto {
    private Integer idProfesor;
    private PersonaOutputDto personaOutputDto;
    private String comments;
    private String branch;

    public ProfesorOutputDto(Profesor profesor){
        setIdProfesor(profesor.getIdProfesor());
        setPersonaOutputDto(new PersonaOutputDto(profesor.getPersona()));
        setComments(profesor.getComentarios());
        setBranch(profesor.getBranch());
    }
}

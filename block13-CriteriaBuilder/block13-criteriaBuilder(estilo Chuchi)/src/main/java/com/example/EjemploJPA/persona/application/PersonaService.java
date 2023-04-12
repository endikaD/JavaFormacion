package com.example.EjemploJPA.persona.application;

import com.example.EjemploJPA.persona.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto) throws EntityNotFoundException;

    PersonaOutputDto obtenerPersonaPorUsuario(String usuario);

    PersonaOutputDto obtenerPersonaPorId(Integer id) throws EntityNotFoundException;

    List<PersonaOutputDto> obtenerPersonas();

    PersonaOutputDto actualizarPersona(Integer id, PersonaInputDto personaInputDto) throws Exception;
    void borrarPersona(Integer id) throws Exception;
}

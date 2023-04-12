package com.example.EjemploJPA.application;

import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto);

    PersonaOutputDto actualizarPersona(PersonaInputDto personaInputDto);

    PersonaOutputDto obtenerPersonaPorId(int id);

    PersonaOutputDto obtenerPersonaPorNombre(String nombre);

    Iterable<PersonaOutputDto> obtenerPersonas(int numPag, int tamPag);

    void borrarPersonaPorId(int id);
}

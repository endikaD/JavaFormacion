package com.example.EjemploJPA.application;

import com.example.EjemploJPA.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.domain.Persona;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto);
    List<PersonaOutputDto> listaPersonasPag(int pagina, int tamanio);
    PersonaOutputDto personaId(String id);
    PersonaOutputDto actualizarPersona(String id, PersonaInputDto personaInputDto);
    void borrarPersona(String id);
}

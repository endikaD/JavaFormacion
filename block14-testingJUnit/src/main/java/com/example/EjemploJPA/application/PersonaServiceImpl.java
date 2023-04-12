package com.example.EjemploJPA.application;

import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.PersonaOutputDto;
import com.example.EjemploJPA.domain.Persona;
import com.example.EjemploJPA.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto) {
        return personaRepository.save(new Persona(personaInputDto)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto actualizarPersona(PersonaInputDto personaInputDto) {
        personaRepository.findById(personaInputDto.getId()).orElseThrow();
        return personaRepository.save(new Persona(personaInputDto)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorId(int id) {
        return personaRepository.findById(id).orElseThrow().personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre).personaToPersonaOutputDto();
    }

    @Override
    public Iterable<PersonaOutputDto> obtenerPersonas(int numPag, int tamPag) {
        PageRequest pageRequest = PageRequest.of(numPag, tamPag);
        return personaRepository.findAll(pageRequest).getContent().stream().map(Persona::personaToPersonaOutputDto).toList();
    }

    @Override
    public void borrarPersonaPorId(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }
}

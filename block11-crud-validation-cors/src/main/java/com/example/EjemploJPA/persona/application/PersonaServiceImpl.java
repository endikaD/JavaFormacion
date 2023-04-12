package com.example.EjemploJPA.persona.application;

import com.example.EjemploJPA.persona.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.persona.domain.Persona;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.exceptions.UnprocessableEntityException;
import com.example.EjemploJPA.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto) throws EntityNotFoundException {
        /*
        if (personaRepository.findByUsuario(personaInputDto.getUsuario()) == null) {
            Persona persona = personaInputDtoToEntity(personaInputDto);
            persona.setId(persona.getId());
            personaRepository.save(persona);

            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
            return personaOutputDto;
        }
        System.out.println("Este nombre de usuario ya está cogido");
        return null;

         */
        if (personaRepository.findByUsuario(personaInputDto.getUsuario()) == null) {
            Persona persona = personaInputDtoToEntity(personaInputDto);
            personaRepository.save(persona); //se guarda en repo
            return new PersonaOutputDto(persona); //se devuelve
        } else {
            throw new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now());
        }
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorUsuario(String usuario) {
        Persona persona = personaRepository.findByUsuario(usuario);
        return new PersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorId(Integer id) throws EntityNotFoundException {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now()));
        return new PersonaOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> obtenerPersonas() {
        List<Persona> clients = personaRepository.findAll();
        return clients.stream().map(PersonaOutputDto::new).toList();
    }

    @Override
    public PersonaOutputDto actualizarPersona(Integer id, PersonaInputDto personaInputDto) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now()));
        //falta utils
        persona.setUsuario(personaInputDto.getUsuario());
        persona.setPassword(personaInputDto.getPassword());
        persona.setName(personaInputDto.getName());
        persona.setSurname(personaInputDto.getSurname());
        persona.setCompany_email(personaInputDto.getCompany_email());
        persona.setPersonal_email(personaInputDto.getPersonal_email());
        persona.setCity(personaInputDto.getCity());
        persona.setActive(personaInputDto.isActive());
        persona.setCreated_date(personaInputDto.getCreated_date());
        persona.setImagen_url(personaInputDto.getImagen_url());
        persona.setTermination_date(personaInputDto.getTermination_date());

        personaRepository.save(persona);
        PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
        return personaOutputDto;
    }

    @Override
    public void borrarPersona(Integer id) throws Exception {
        personaRepository.delete(personaRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now())));
    }

    public Persona personaInputDtoToEntity(PersonaInputDto personaInputDto) {
        Persona persona = new Persona();
        persona.setUsuario(personaInputDto.getUsuario());
        persona.setPassword(personaInputDto.getPassword());
        persona.setName(personaInputDto.getName());
        persona.setSurname(personaInputDto.getSurname());
        persona.setCompany_email(personaInputDto.getCompany_email());
        persona.setPersonal_email(personaInputDto.getCompany_email());
        persona.setCity(personaInputDto.getCity());
        persona.setActive(personaInputDto.isActive());
        persona.setCreated_date(personaInputDto.getCreated_date());
        persona.setImagen_url(personaInputDto.getImagen_url());
        persona.setTermination_date(personaInputDto.getTermination_date());

        return persona;
    }
}

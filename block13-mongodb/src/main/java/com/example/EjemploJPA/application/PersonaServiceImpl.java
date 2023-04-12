package com.example.EjemploJPA.application;

import com.example.EjemploJPA.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.domain.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor  //Sustituye a los Autowired
public class PersonaServiceImpl implements PersonaService{


   //private final PersonaRepository personaRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto) {
        Persona persona = new Persona(personaInputDto);
        mongoTemplate.save(persona);
        return new PersonaOutputDto(persona);

        //return new PersonaOutputDto(mongoTemplate.save(new Persona(personaInputDto))); //ES LO MISMO EN UNA LINEA


//        Persona persona = new Persona();
//        //persona.setId(personaInputDto.getId());
//        persona.setNombre(personaInputDto.getNombre());
//        persona.setEdad(personaInputDto.getEdad());
//        persona.setPoblacion(personaInputDto.getPoblacion());
//
//        personaRepository.save(persona);
//        return new PersonaOutputDto(persona); // PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
//                                              // return personaOutputDto;
//                                              // *ES LO MISMO*
//

    }

    @Override
    public List<PersonaOutputDto> listaPersonasPag(int pagina, int tamaño) {

        List<Persona> persons = mongoTemplate.findAll(Persona.class);

        Comparator <Persona> comparator = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        return persons.stream()
                .sorted(comparator)
                .skip(pagina*tamaño)
                .limit(tamaño)
                .map(PersonaOutputDto::new)
                .toList();



//        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
//        return mongoTemplate.findAll(pageRequest).getContent().stream().map(PersonaOutputDto::new).toList();
    }

    @Override
    public PersonaOutputDto personaId(String id) {
        Persona persona = mongoTemplate.findById(id, Persona.class);
        return new PersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto actualizarPersona(String id, PersonaInputDto personaInputDto) {
        Persona pEncontrada = mongoTemplate.findById(id, Persona.class);

        Persona pNuevo = new Persona(personaInputDto);
        pNuevo.setId(pEncontrada.getId());
        mongoTemplate.save(pNuevo);
        return new PersonaOutputDto(pNuevo);


        //Persona pEncontrada = mongoTemplate.findById(id);
//        //persona.setId(personaInputDto.getId());
//        persona.setNombre(personaInputDto.getNombre());
//        persona.setEdad(personaInputDto.getEdad());
//        persona.setPoblacion(personaInputDto.getPoblacion());
//
//        mongoTemplate.save(persona);
//        return new PersonaOutputDto(persona);
    }

    @Override
    public void borrarPersona(String id) {
        mongoTemplate.remove(mongoTemplate.findById(id, Persona.class));
    }
}

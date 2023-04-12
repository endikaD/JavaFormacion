package com.example.EjemploJPA;
import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.PersonaOutputDto;
import org.junit.jupiter.api.Assertions;

public class AñadirPersona {
    public static void crearPersona(PersonaInputDto personaInputDto){
        personaInputDto.setId(1);
        personaInputDto.setNombre("Endika");
        personaInputDto.setEdad(24);
        personaInputDto.setPoblacion("Sestao");
    }

    public static void afirmacionesPersonas(PersonaInputDto personaInputDto, PersonaOutputDto personaOutputDto){
        Assertions.assertEquals(personaInputDto.getId(), personaOutputDto.getId());
        Assertions.assertEquals(personaInputDto.getNombre(), personaOutputDto.getNombre());
        Assertions.assertEquals(personaInputDto.getEdad(), personaOutputDto.getEdad());
        Assertions.assertEquals(personaInputDto.getPoblacion(), personaOutputDto.getPoblacion());
    }
}

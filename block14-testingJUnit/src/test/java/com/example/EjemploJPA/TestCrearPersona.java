package com.example.EjemploJPA;

import com.example.EjemploJPA.application.PersonaService;
import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.EjemploJPA.AñadirPersona.afirmacionesPersonas;
import static com.example.EjemploJPA.AñadirPersona.crearPersona;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCrearPersona {
    @Autowired
    private PersonaService personaService;

    @Test
    void crearPersonaT() throws Exception{
        PersonaInputDto personaInputDto = new PersonaInputDto();
        crearPersona(personaInputDto);
        afirmacionesPersonas(personaInputDto, personaService.añadirPersona(personaInputDto));
    }
}

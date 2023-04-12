package com.example.EjemploJPA;


import com.example.EjemploJPA.application.PersonaService;
import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import org.junit.jupiter.api.BeforeAll;
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
public class TestActualizarPersona {
    @Autowired
    private PersonaService personaService;

    @BeforeAll
    void setUp() {
        PersonaInputDto personaInputDto = new PersonaInputDto();
        crearPersona(personaInputDto);
        personaService.añadirPersona(personaInputDto);
    }

    @Test
    void actualizarPersona() {
        PersonaInputDto personaInputDto = new PersonaInputDto(1,"Endika","Logroño",94);
        afirmacionesPersonas(personaInputDto, personaService.actualizarPersona(personaInputDto));
    }
}

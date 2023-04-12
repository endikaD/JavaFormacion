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
public class TestObtenerPersona {
    @Autowired
    private PersonaService personaService;

    @BeforeAll
    void setUp() {
        PersonaInputDto personaInputDto = new PersonaInputDto();
        crearPersona(personaInputDto);
        personaService.añadirPersona(personaInputDto);
    }

    @Test
    void obtenerTodos() {
        personaService.obtenerPersonas(0, 4);
    }

    @Test
    void obtenerPorId() {
        PersonaInputDto personaInputDto = new PersonaInputDto();
        crearPersona(personaInputDto);
        afirmacionesPersonas(personaInputDto, personaService.obtenerPersonaPorId(1));
    }

    @Test
    void obtenerPorNombre() {
        personaService.obtenerPersonaPorNombre("Endika");
    }
}

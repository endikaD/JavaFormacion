package com.example.EjemploJPA.controller;

import com.example.EjemploJPA.application.PersonaServiceImpl;
import com.example.EjemploJPA.controller.dto.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.PersonaOutputDto;
import com.example.EjemploJPA.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> añadirPersona(@RequestBody PersonaInputDto personaInputDto) {
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.añadirPersona(personaInputDto));
    }

    @PutMapping
    public ResponseEntity<PersonaOutputDto> actualizarPersona(@RequestBody PersonaInputDto personaInputDto) {
        try {
            personaService.obtenerPersonaPorId(personaInputDto.getId());
            PersonaOutputDto personaOutputDto = personaService.actualizarPersona(personaInputDto);
            return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("No se ha encontrado.");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPersonaPorId(@PathVariable int id) {
        try {
            personaService.borrarPersonaPorId(id);
            return ResponseEntity.ok().body("Es estudiante con ID: " + id + " ha sido eliminado.");
        } catch (Exception e) {
            System.out.println("No se ha encontrado.");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> obtenerPersonaPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.obtenerPersonaPorId(id));
        } catch (Exception e) {
            System.out.println("No se ha encontrado.");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<PersonaOutputDto> obtenerPersonaPorNombre(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok().body(personaService.obtenerPersonaPorNombre(nombre));
        } catch (Exception e) {
            System.out.println("No se ha encontrado.");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<PersonaOutputDto> obtenerTodasPersonas(@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                           @RequestParam(defaultValue = "4", required = false) int pageSize) {
        return personaService.obtenerPersonas(pageNumber, pageSize);
    }


}

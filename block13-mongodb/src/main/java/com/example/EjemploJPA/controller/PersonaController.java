package com.example.EjemploJPA.controller;

import com.example.EjemploJPA.application.PersonaService;
import com.example.EjemploJPA.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.controller.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaOutputDto añadirPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.añadirPersona(personaInputDto);
    }
    @GetMapping
    public List<PersonaOutputDto> obtenerListaPersonas(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                                       @RequestParam(defaultValue = "4", required = false) Integer tamanio){
        return personaService.listaPersonasPag(pagina, tamanio);
    }
    @GetMapping("/{id}")
    public PersonaOutputDto obtenerPersonaPorId(@PathVariable String id) throws Exception {
        return personaService.personaId(id);
    }
    @PutMapping("/{id}")
    public PersonaOutputDto actualizarPersona(@PathVariable String id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.actualizarPersona(id, personaInputDto);
    }
    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable String id) throws Exception {
        personaService.borrarPersona(id);
    }
}

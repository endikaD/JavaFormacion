package com.example.EjemploJPA.persona.controller;

import com.example.EjemploJPA.feign.Feign;
import com.example.EjemploJPA.persona.application.PersonaService;
import com.example.EjemploJPA.persona.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @Autowired
    Feign feign;

    @PostMapping
    public PersonaOutputDto añadirPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.añadirPersona(personaInputDto);
    }

    @GetMapping("/nombre/{usuario}")
    public PersonaOutputDto obtenerPersonaPorNombre(@PathVariable String usuario){
        return personaService.obtenerPersonaPorUsuario(usuario);
    }

    @GetMapping("/id/{id}")
    public PersonaOutputDto obtenerPersonaPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return personaService.obtenerPersonaPorId(id);
    }

    @GetMapping("/personas")
    public List<PersonaOutputDto> obtenerListaPersonas(){
        return personaService.obtenerPersonas();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable Integer id) throws Exception {
        personaService.borrarPersona(id);
    }
    @PutMapping("/actualizar/{id}")
    public PersonaOutputDto actualizarPersona(@PathVariable Integer id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.actualizarPersona(id, personaInputDto);
    }

    @GetMapping("/profesor/{id}")
    ResponseEntity<ProfesorOutputDto> getProfesorRestTemplate(@PathVariable Integer id){
        ResponseEntity<ProfesorOutputDto> rs = new RestTemplate().getForEntity("http://localhost:8080/profesor/"+id,ProfesorOutputDto.class);
        return ResponseEntity.ok(rs.getBody());
    }

    @GetMapping("/feing/{id}")
    ResponseEntity<ProfesorOutputDto> getProfesorFeign(@PathVariable Integer id){
        ResponseEntity<ProfesorOutputDto> rs = feign.callServer(id);
        return rs;
    }
}

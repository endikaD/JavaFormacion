package com.example.EjemploJPA.persona.controller;

import com.example.EjemploJPA.feign.Feign;
import com.example.EjemploJPA.persona.application.PersonaService;
import com.example.EjemploJPA.persona.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.persona.domain.Persona;
import com.example.EjemploJPA.persona.repository.PersonaRepository;
import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @Autowired
    Feign feign;
    @Autowired
    EntityManager em; //Autowired del EntityManager

    public static final String GREATER_THAN="greater";  //Variables estáticas
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";
    @Autowired
    private PersonaRepository personaRepository;

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
    @GetMapping("/get")
    public List<Persona> getData(@RequestParam(required=false,value="usuario") String usuario,
                                 @RequestParam(required=false, value="nombre") String nombre,
                                 @RequestParam(required=false, value="apellido") String apellido,
                                 @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date fechaCreacion,
                                 @RequestParam(required=false) String dateCondition)
    {
        HashMap<String, Object> data=new HashMap<>();

        if (usuario!=null)
            data.put("usuario",usuario);
        if (nombre!=null)
            data.put("nombre",nombre);
        if (apellido!=null)
            data.put("apellido",apellido);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;
        if (fechaCreacion!=null)
        {
            data.put("fechaCreacion",fechaCreacion);
            data.put("dateCondition",dateCondition);
        }

        return personaRepository.getData(data);
    }
}

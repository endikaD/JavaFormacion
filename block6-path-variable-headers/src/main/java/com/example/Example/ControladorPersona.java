package com.example.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ControladorPersona {

    @Autowired
    Servicio servicio;

    @PostMapping("/usuario")                                        // Parte 1
    public Persona aniadirPersona(@RequestBody Persona persona){
        servicio.setPersona(persona);
        return servicio.getPersona();
    }

    @GetMapping("/usuario/{id}")                                    // Parte 2
    public int obtenerId(@PathVariable int id){
        return id;
    }

    @PutMapping("/post")                                            // Parte 3
    public HashMap getVar(@RequestParam(name= "var1") String var1,
                          @RequestParam(name= "var2") String var2){
        return servicio.addVar(var1, var2);
    }

}

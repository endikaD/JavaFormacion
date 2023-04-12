package com.example.Example;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador {
    @GetMapping(value= "/user/{nombre}")
    public String holaPersona(@PathVariable String nombre){
        return "Holaaa " + nombre;
    }

    @PostMapping("/useradd")
    public Persona añadirPersona (@RequestBody Persona añadirPersona){ // Esta es la información que recibe, un objeto de la clase Persona
        Persona persona = añadirPersona; // La informacion se guarda en un objeto de la misma clase
        persona.setEdad(persona.getEdad() + 1); // Hacemos que la edad sea la introducida en el json + 1
        return persona; // Mostramos los datos del objeto persona
    }
}
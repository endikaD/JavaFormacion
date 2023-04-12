package com.example.Example;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controlador2 {
    private Servicio servicio;

    @GetMapping("/controlador2/getPersona")
    public Persona getPersonaEdadX2 () {
        Persona persona = servicio.crearPersona("Endika","Sestao",23);
        persona.setEdad(persona.getEdad()*2);
        return persona;
    }

    @GetMapping("/controlador2/getCiudades")
    public List<Ciudad> getCiudad(){
        return servicio.getCiudades();
    }
}

package com.example.Example;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controlador1 {
    private Servicio servicio;

    @GetMapping("/controlador1/addPersona")
    public Persona addPersona(@RequestHeader("nombre") String nombre, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") int edad) {
        return servicio.crearPersona(nombre, poblacion, edad);
    }

    @PostMapping("/controlador1/addCiudad")
    public void aniadirCiudad(@RequestBody Ciudad ciudad){
        servicio.añadirCiudad(ciudad);
    }

}

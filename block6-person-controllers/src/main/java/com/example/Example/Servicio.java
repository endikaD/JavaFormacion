package com.example.Example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    private Persona persona;
    private Ciudad ciudad;
    private List<Ciudad> ciudades = new ArrayList<Ciudad>();
    public Persona crearPersona(String nombre, String poblacion, int edad) {  // Metodo para crear una persona
        persona = new Persona(nombre, poblacion, edad);
        return persona;
    }

    public void añadirCiudad(Ciudad ciudad) {   // Metodo para añadir ciudades a la lista de ciudades
        ciudades.add(ciudad);
    }
}

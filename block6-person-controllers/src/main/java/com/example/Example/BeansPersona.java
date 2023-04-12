package com.example.Example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansPersona {
    @Bean("primeroBean")
    public Persona bean1() {
        String nombre = "Endika";
        int edad = 23;
        String poblacion = "Bilbao";

        return new Persona(nombre,poblacion,edad);
    }
    @Bean("segundoBean")
    public Persona bean2() {
        String nombre = "Tatiana";
        int edad = 22;
        String poblacion = "Ezcaray";

        return new Persona(nombre,poblacion,edad);
    }
    @Bean("terceroBean")
    public Persona bean3() {
        String nombre = "Miguel";
        int edad = 21;
        String poblacion = "Logroño";

        return new Persona(nombre,poblacion,edad);
    }
}

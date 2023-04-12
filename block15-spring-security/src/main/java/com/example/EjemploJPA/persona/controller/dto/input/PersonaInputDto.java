package com.example.EjemploJPA.persona.controller.dto.input;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String emailCompañia;
    private String emailPersonal;
    private String city;
    private boolean activo;
    private Date fechaCreacion;
    private String urlImagen;
    private Date fechaFinalizacion;
}

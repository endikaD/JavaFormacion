package com.example.EjemploJPA.persona.controller.dto;

import com.example.EjemploJPA.persona.application.Campos;
import lombok.Data;

import java.util.Date;
@Data
public class QueryDto {
    String usuario;
    String nombre;
    String apellido;
    Date fechaCreacion;
    String dateCondition;
    Integer pagina;
    Integer tamaño;
    Integer campo;
}

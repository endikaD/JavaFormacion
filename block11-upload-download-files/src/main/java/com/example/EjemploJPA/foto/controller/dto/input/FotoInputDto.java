package com.example.EjemploJPA.foto.controller.dto.input;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FotoInputDto {
    private String titulo;
    private Date fecha;
    private String type;
    private byte[] fileData;
    private Integer idActividad;
}

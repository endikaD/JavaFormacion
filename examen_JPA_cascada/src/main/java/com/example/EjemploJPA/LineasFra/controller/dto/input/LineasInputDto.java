package com.example.EjemploJPA.LineasFra.controller.dto.input;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineasInputDto {
    private String nombreProducto;
    private double precio;
    private double cantidad;
    private Integer idCabecera;
}

package com.example.EjemploJPA.CabeceraFra.controller.dto.input;

import com.example.EjemploJPA.Cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraInputDto {
    private double importeFra;
    private Integer idCliente;
}

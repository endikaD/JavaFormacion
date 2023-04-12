package com.example.EjemploJPA.LineasFra.controller.dto.output;

import com.example.EjemploJPA.CabeceraFra.controller.dto.output.CabeceraOutputDto;
import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;
import com.example.EjemploJPA.LineasFra.domain.Linea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineasOutputDto {
    private Integer idLineas;
    private String nombreProducto;
    private double precio;
    private double cantidad;
    private CabeceraOutputDto cabeceraOutputDto;
    public LineasOutputDto(Linea linea){
        setIdLineas(linea.getIdLineas());
        setNombreProducto(linea.getNombreProducto());
        setPrecio(linea.getPrecio());
        setCantidad(linea.getCantidad());
        setCabeceraOutputDto(new CabeceraOutputDto(linea.getCabecera()));
    }
}

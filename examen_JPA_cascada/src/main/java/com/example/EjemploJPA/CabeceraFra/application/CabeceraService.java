package com.example.EjemploJPA.CabeceraFra.application;

import com.example.EjemploJPA.CabeceraFra.controller.dto.input.CabeceraInputDto;
import com.example.EjemploJPA.CabeceraFra.controller.dto.output.CabeceraOutputDto;

import java.util.List;

public interface CabeceraService {
    CabeceraOutputDto añadirCabecera(CabeceraInputDto cabeceraInputDto);
    CabeceraOutputDto obtenerCabeceraPorId(Integer id);
    List<CabeceraOutputDto> obtenerCabeceras();
    CabeceraOutputDto actualizarCabecera(Integer id, CabeceraInputDto CabeceraInputDto);
    void borrarCabecera(Integer id);
}

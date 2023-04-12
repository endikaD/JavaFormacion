package com.example.EjemploJPA.LineasFra.application;
import com.example.EjemploJPA.LineasFra.controller.dto.input.LineasInputDto;
import com.example.EjemploJPA.LineasFra.controller.dto.output.LineasOutputDto;

import java.util.List;

public interface LineasService {
    LineasOutputDto añadirLinea(LineasInputDto lineasInputDto);
    LineasOutputDto obtenerLineaPorId(Integer id);
    List<LineasOutputDto> obtenerLineas();
    LineasOutputDto actualizarLinea(Integer id, LineasInputDto lineasInputDto);
    void borrarLinea(Integer id);
}

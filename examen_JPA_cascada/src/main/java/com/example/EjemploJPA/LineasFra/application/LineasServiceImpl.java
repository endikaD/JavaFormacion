package com.example.EjemploJPA.LineasFra.application;

import com.example.EjemploJPA.CabeceraFra.controller.dto.input.CabeceraInputDto;
import com.example.EjemploJPA.CabeceraFra.controller.dto.output.CabeceraOutputDto;
import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import com.example.EjemploJPA.CabeceraFra.repository.CabeceraRepository;
import com.example.EjemploJPA.LineasFra.controller.dto.input.LineasInputDto;
import com.example.EjemploJPA.LineasFra.controller.dto.output.LineasOutputDto;
import com.example.EjemploJPA.LineasFra.domain.Linea;
import com.example.EjemploJPA.LineasFra.repository.LineasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LineasServiceImpl implements LineasService{
    @Autowired
    LineasRepository lineasRepository;
    @Autowired
    CabeceraRepository cabeceraRepository;
    @Override
    public LineasOutputDto añadirLinea(LineasInputDto lineasInputDto) {
        Linea linea = lineaInputDtoToEntity(lineasInputDto);
        lineasRepository.save(linea);
        return new LineasOutputDto(linea);
    }

    @Override
    public LineasOutputDto obtenerLineaPorId(Integer id) {
        Linea linea = lineasRepository.findById(id).orElseThrow();
        return new LineasOutputDto(linea);
    }

    @Override
    public List<LineasOutputDto> obtenerLineas() {
        List<Linea> lineas = lineasRepository.findAll();
        return lineas.stream().map(LineasOutputDto::new).toList();
    }

    @Override
    public LineasOutputDto actualizarLinea(Integer id, LineasInputDto lineasInputDto) {
        Linea linea = lineasRepository.findById(id).orElseThrow();
        linea.setNombreProducto(lineasInputDto.getNombreProducto());
        linea.setPrecio(lineasInputDto.getPrecio());
        linea.setCantidad(lineasInputDto.getCantidad());
        linea.setCabecera(cabeceraRepository.findById(lineasInputDto.getIdCabecera()).orElseThrow());
        lineasRepository.save(linea);
        return new LineasOutputDto(linea);
    }

    @Override
    public void borrarLinea(Integer id) {
        lineasRepository.delete(lineasRepository.findById(id).orElseThrow());
    }

    public Linea lineaInputDtoToEntity(LineasInputDto lineasInputDto){
        Linea linea = new Linea();
        linea.setNombreProducto(lineasInputDto.getNombreProducto());
        linea.setPrecio(lineasInputDto.getPrecio());
        linea.setCantidad(lineasInputDto.getCantidad());
        linea.setCabecera(cabeceraRepository.findById(lineasInputDto.getIdCabecera()).orElseThrow());
        return linea;
    }
}

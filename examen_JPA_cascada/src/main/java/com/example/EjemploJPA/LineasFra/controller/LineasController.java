package com.example.EjemploJPA.LineasFra.controller;

import com.example.EjemploJPA.CabeceraFra.application.CabeceraService;
import com.example.EjemploJPA.CabeceraFra.controller.dto.input.CabeceraInputDto;
import com.example.EjemploJPA.CabeceraFra.controller.dto.output.CabeceraOutputDto;
import com.example.EjemploJPA.LineasFra.application.LineasService;
import com.example.EjemploJPA.LineasFra.controller.dto.input.LineasInputDto;
import com.example.EjemploJPA.LineasFra.controller.dto.output.LineasOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/linea")
public class LineasController {
    @Autowired
    LineasService lineasService;
    @PostMapping
    public LineasOutputDto añadirLinea(@RequestBody LineasInputDto lineasInputDto){
       return lineasService.añadirLinea(lineasInputDto);
    }
    @GetMapping("/{id}")
    public LineasOutputDto obtenerLineaPorId(@PathVariable Integer id){
        return lineasService.obtenerLineaPorId(id);
    }
    @GetMapping
    public List<LineasOutputDto> obtenerLineas(){
        return lineasService.obtenerLineas();
    }
    @PutMapping("/{id}")
    public LineasOutputDto actualizarLinea(@PathVariable Integer id, @RequestBody LineasInputDto lineasInputDto){
        return lineasService.actualizarLinea(id, lineasInputDto);
    }
    @DeleteMapping("/{id}")
    public void borrarLinea(@PathVariable Integer id){
        lineasService.borrarLinea(id);
    }
}

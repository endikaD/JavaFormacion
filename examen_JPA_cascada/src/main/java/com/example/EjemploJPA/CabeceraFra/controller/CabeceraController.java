package com.example.EjemploJPA.CabeceraFra.controller;

import com.example.EjemploJPA.CabeceraFra.application.CabeceraService;
import com.example.EjemploJPA.CabeceraFra.controller.dto.input.CabeceraInputDto;
import com.example.EjemploJPA.CabeceraFra.controller.dto.output.CabeceraOutputDto;
import com.example.EjemploJPA.Cliente.controller.dto.input.ClienteInputDto;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class CabeceraController {
    @Autowired
    CabeceraService cabeceraService;
    @PostMapping
    public CabeceraOutputDto añadirCabecera(@RequestBody CabeceraInputDto cabeceraInputDto){
        return cabeceraService.añadirCabecera(cabeceraInputDto);
    }
    @GetMapping("/{id}")
    public CabeceraOutputDto obtenerCabeceraPorId(@PathVariable Integer id){
        return cabeceraService.obtenerCabeceraPorId(id);
    }
    @GetMapping
    public ResponseEntity <List<CabeceraOutputDto>> obtenerCabeceras(){
        return new ResponseEntity<>(cabeceraService.obtenerCabeceras(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public CabeceraOutputDto actualizarCabecera(@PathVariable Integer id, @RequestBody CabeceraInputDto cabeceraInputDto){
        return cabeceraService.actualizarCabecera(id, cabeceraInputDto);
    }
    @DeleteMapping("/{id}")
    public void borrarCabecera(@PathVariable Integer id){
        cabeceraService.borrarCabecera(id);
    }
}

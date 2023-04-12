package com.example.EjemploJPA.asignatura.controller;

import com.example.EjemploJPA.asignatura.application.AsignaturaService;
import com.example.EjemploJPA.asignatura.controller.dto.input.AsignaturaInputDto;
import com.example.EjemploJPA.asignatura.controller.dto.output.AsignaturaOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    AsignaturaService asignaturaService;
    @PostMapping
    public AsignaturaOutputDto añadirAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException {
        return asignaturaService.añadirAsignatura(asignaturaInputDto);
    }
    @PostMapping("/asignatura")
    public AsignaturaOutputDto añadirAsignaturaAEstudiante(Integer idAsignatura, Integer idEstudiante) throws EntityNotFoundException {
        asignaturaService.añadirAsignaturaAEstudiante(idAsignatura,idEstudiante);
        return null;
    }
    @GetMapping("/id/{id}")
    public AsignaturaOutputDto obtenerAsignaturaPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return asignaturaService.obtenerAsignaturaPorId(id);
    }
    @GetMapping("/asignaturas")
    public List<AsignaturaOutputDto> obtenerListaAsignaturas(){
        return asignaturaService.obtenerAsignaturas();
    }
    @DeleteMapping("/borrar/{id}")
    public void borrarAsignatura(@PathVariable Integer id) throws Exception {
        asignaturaService.borrarAsignatura(id);
    }
    @PutMapping("/actualizar/{id}")
    public AsignaturaOutputDto actualizarAsignatura(@PathVariable Integer id, @RequestBody AsignaturaInputDto asignaturaInputDto) throws Exception {
        return asignaturaService.actualizarAsignatura(id, asignaturaInputDto);
    }
}

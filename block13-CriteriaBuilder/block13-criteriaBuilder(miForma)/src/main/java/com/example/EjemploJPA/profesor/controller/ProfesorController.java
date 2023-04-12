package com.example.EjemploJPA.profesor.controller;

import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.profesor.application.ProfesorService;
import com.example.EjemploJPA.profesor.controller.dto.input.ProfesorInputDto;
import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;
    @PostMapping
    public ProfesorOutputDto añadirProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws Exception {
        return profesorService.añadirProfesor(profesorInputDto);
    }
    @GetMapping("/id/{id}")
    public ProfesorOutputDto obtenerProfesorPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return profesorService.obtenerProfesorPorId(id);
    }
    @GetMapping("/profesores")
    public List<ProfesorOutputDto> obtenerListaProfesores(){
        return profesorService.obtenerProfesores();
    }
    @DeleteMapping("/borrar/{id}")
    public void borrarProfesor(@PathVariable Integer id) throws Exception {
        profesorService.borrarProfesor(id);
    }
    @PutMapping("/actualizar/{id}")
    public ProfesorOutputDto actualizarProfesor(@PathVariable Integer id, @RequestBody ProfesorInputDto profesorInputDto) throws Exception {
        return profesorService.actualizarProfesor(id, profesorInputDto);
    }
}

package com.example.EjemploJPA.estudiante.controller;

import com.example.EjemploJPA.estudiante.application.EstudianteService;
import com.example.EjemploJPA.estudiante.controller.dto.input.EstudianteInputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteOutputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteSimpleOutputDto;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;
    @PostMapping
    public EstudianteOutputDto añadirEstudiante(@RequestBody EstudianteInputDto estudianteInputDto) throws Exception {
        return estudianteService.añadirEstudiante(estudianteInputDto);
    }
    @GetMapping("/{id}")
    public EstudianteSimpleOutputDto obtenerEstudiantePorId(@PathVariable Integer id, @RequestParam(name = "outputType") String outputType) throws EntityNotFoundException {
        if (outputType.equalsIgnoreCase("simple")){
            return estudianteService.obtenerEstudianteSimplePorId(id, outputType);
        }else
            return estudianteService.obtenerEstudianteFullPorId(id, outputType);
    }
    @GetMapping("/estudiantes")
    public List<EstudianteOutputDto> obtenerListaEstudiantes(){
        return estudianteService.obtenerEstudiantes();
    }
    @DeleteMapping("/borrar/{id}")
    public void borrarEstudiante(@PathVariable Integer id) throws Exception {
        estudianteService.borrarEstudiante(id);
    }
    @PutMapping("/actualizar/{id}")
    public EstudianteOutputDto actualizarEstudiante(@PathVariable Integer id, @RequestBody EstudianteInputDto estudianteInputDto) throws Exception {
        return estudianteService.actualizarEstudiante(id, estudianteInputDto);
    }
}

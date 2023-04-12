package com.example.EjemploJPA.foto.controller;

import JesuitasDeFiesta.JesuitasDeFiesta.foto.application.FotoService;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.input.FotoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.output.FotoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/foto")
public class FotoController {
    @Autowired
    FotoService fotoService;


//    @PostMapping
//    public FotoOutputDto añadirFoto(@RequestBody FotoInputDto fotoInputDto) throws Exception {
//        return fotoService.añadirFoto(fotoInputDto);
//    }
    @PostMapping
    public ResponseEntity<String> subirFoto(@RequestParam("files")MultipartFile multipartFile, @RequestBody FotoInputDto fotoInputDto) throws Exception {
        fotoService.subirFoto(multipartFile, fotoInputDto);
        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos");
    }

    @GetMapping
    public List<FotoOutputDto> obtenerListaFotos(@RequestParam(defaultValue = "0", required = false) Integer pagina, @RequestParam(defaultValue = "4", required = false) Integer tamanio) {
        return fotoService.obtenerFotos(pagina, tamanio);
    }

    @GetMapping("/{id}")
    public FotoOutputDto obtenerFotoPorId(@PathVariable Integer id) throws Exception {
        return fotoService.obtenerFotoPorId(id);
    }

    @PutMapping("/{id}")
    public FotoOutputDto actualizarFoto(@RequestParam("files") MultipartFile multipartFile, @PathVariable Integer id, @RequestBody FotoInputDto fotoInputDto) throws Exception {
        return fotoService.actualizarFoto(multipartFile, id, fotoInputDto);
    }

    @DeleteMapping("/{id}")
    public void borrarFoto(@PathVariable Integer id) throws Exception {
        fotoService.borrarFoto(id);
    }
}

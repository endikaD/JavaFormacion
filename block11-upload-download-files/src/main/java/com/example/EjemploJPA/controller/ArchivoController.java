package com.example.EjemploJPA.controller;

import com.example.EjemploJPA.application.FileServiceAPI;
import com.example.EjemploJPA.domain.Archivo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class ArchivoController {
    @Autowired
    private FileServiceAPI fileServiceAPI;
    @PostMapping("/upload")
    public ResponseEntity<String> subirArchivos(@RequestParam("files")List<MultipartFile> files) throws Exception {
        fileServiceAPI.guardar(files);
        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos");
    }
    @PostMapping("/upload/db")
    public ResponseEntity<String> subirDB(@RequestParam("files")MultipartFile multipartFile) throws Exception {
        fileServiceAPI.subirDB(multipartFile);
        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos");
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> obtenerFileId(@PathVariable("id") Integer id) throws Exception {
        Archivo archivo = fileServiceAPI.obtenerPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(archivo);
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Object> obtenerFileNombre(@PathVariable("nombre") String nombre) throws Exception {
        Archivo archivo = fileServiceAPI.obtenerPorNombre(nombre);
        return ResponseEntity.status(HttpStatus.OK).body(archivo);
    }
    @GetMapping("/idmap/{id}")
    public ResponseEntity<Object> obtenerFileIdMappeo(@PathVariable("id") Integer id) throws Exception {
        ResponseEntity<Object> archivo = fileServiceAPI.obtenerPorIdMappeo(id);
        return archivo;
    }
    @GetMapping("/nombremap/{nombre}")
    public ResponseEntity<Object> obtenerFileNombreMappeo(@PathVariable("nombre") String nombre) throws Exception {
        ResponseEntity<Object> archivo = fileServiceAPI.obtenerPorNombreMappeo(nombre);
        return archivo;
    }
    @GetMapping("/descargarid/{id}")
    public void descargarFileId(@PathVariable("id") Integer id) throws Exception {
        fileServiceAPI.descargarPorId(id);
    }
    @GetMapping("/descargarnombre/{nombre}")
    public void descargarFileNombre(@PathVariable("nombre") String nombre) throws Exception {
        fileServiceAPI.descargarPorNombre(nombre);
    }
}

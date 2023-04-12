package com.example.EjemploJPA.application;

import com.example.EjemploJPA.domain.Archivo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileServiceAPI {
    public void guardar(MultipartFile file) throws Exception;
    public void guardar(List<MultipartFile> file) throws Exception;
    public Archivo subirDB(MultipartFile multipartFile) throws IOException;
    public Archivo obtenerPorId(Integer id);
    public Archivo obtenerPorNombre(String nombre);
    public ResponseEntity<Object> obtenerPorIdMappeo(Integer id);
    public ResponseEntity<Object> obtenerPorNombreMappeo(String nombre);
    public void descargarPorId(Integer id) throws IOException;
    public void descargarPorNombre(String nombre) throws IOException;

}

package com.example.EjemploJPA.application;

import com.example.EjemploJPA.domain.Archivo;
import com.example.EjemploJPA.repository.ArchivoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileServiceAPI{
    private final Path rootFolder = Paths.get("uploads");
    private final ArchivoRepository archivoRepository;
//    private final ModelMapper modelMapper;
    @Override
    public void guardar(MultipartFile file) throws Exception {
        Files.copy(file.getInputStream(), this.rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())));
    }

    @Override
    public void guardar(List<MultipartFile> files) throws Exception {
        for (MultipartFile file : files) {
            this.guardar(file);
        }
    }

    @Override
    public Archivo subirDB(MultipartFile fileDB) throws IOException {
        Archivo archivo = new Archivo();
        archivo.setNombre(fileDB.getOriginalFilename());
        archivo.setFechaSubida(new Date());
        archivo.setType(fileDB.getContentType());
        archivo.setFileData(fileDB.getBytes());
        return archivoRepository.save(archivo);
    }

    @Override
    public Archivo obtenerPorId(Integer id) {
        Optional<Archivo> archivo = archivoRepository.findById(id);
        return new ModelMapper().map(archivo, Archivo.class);
    }

    @Override
    public Archivo obtenerPorNombre(String nombre) {
        Archivo archivo = archivoRepository.findFileByNombre(nombre);
        return new ModelMapper().map(archivo, Archivo.class);
    }

    @Override
    public ResponseEntity <Object> obtenerPorIdMappeo(Integer id) {
        Optional<Archivo> archivo = archivoRepository.findById(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(archivo.get().getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + archivo.get().getNombre())
                .body(new ByteArrayResource(archivo.get().getFileData()));
    }

    @Override
    public ResponseEntity <Object> obtenerPorNombreMappeo(String nombre) {
        Optional<Archivo> archivo = Optional.ofNullable(archivoRepository.findFileByNombre(nombre));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(archivo.get().getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + archivo.get().getNombre())
                .body(new ByteArrayResource(archivo.get().getFileData()));
    }

    @Override
    public void descargarPorId(Integer id) throws IOException {
        Archivo archivo = archivoRepository.findById(id).orElseThrow();
        File file = new File(archivo.getNombre());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(archivo.getFileData());
        fileOutputStream.close();
    }

    @Override
    public void descargarPorNombre(String nombre) throws IOException {
        Archivo archivo = archivoRepository.findFileByNombre(nombre);
        File file = new File(archivo.getNombre());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(archivo.getFileData());
        fileOutputStream.close();
    }
}

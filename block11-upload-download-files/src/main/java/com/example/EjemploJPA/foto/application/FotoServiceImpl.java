package com.example.EjemploJPA.foto.application;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.repository.ActividadRepository;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.input.FotoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.output.FotoOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.domain.Foto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FotoServiceImpl implements FotoService{
    @Autowired
    FotoRepository fotoRepository;
    @Autowired
    ActividadRepository actividadRepository;

//    @Override
//    public FotoOutputDto añadirFoto(FotoInputDto fotoInputDto) {
//        Foto foto = new Foto();
//        foto.setTitulo(fotoInputDto.getTitulo());
//        foto.setDescripcion(fotoInputDto.getDescripcion());
//        foto.setFecha(fotoInputDto.getFecha());
//        foto.setActividad(actividadRepository.findById(fotoInputDto.getIdActividad()).orElseThrow());
//
//        fotoRepository.save(foto);
//        return new FotoOutputDto(foto);
//    }

    @Override
    public FotoOutputDto obtenerFotoPorId(Integer id) {
        Foto foto = fotoRepository.findById(id).orElseThrow();
        return new FotoOutputDto(foto);
    }

    @Override
    public List<FotoOutputDto> obtenerFotos(Integer pagina, Integer tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        return fotoRepository.findAll(pageRequest).getContent().stream().map(FotoOutputDto::new).toList();
    }

    @Override
    public FotoOutputDto actualizarFoto(MultipartFile fileDB, Integer id, FotoInputDto fotoInputDto) throws IOException {
        Foto foto = fotoRepository.findById(id).orElseThrow();

        foto.setTitulo(fileDB.getOriginalFilename());
        foto.setFecha(new Date());
        foto.setType(fileDB.getContentType());
        foto.setFileData(fileDB.getBytes());
        //foto.setActividad(actividadRepository.findById(fotoInputDto.getIdActividad()).orElseThrow());

        fotoRepository.save(foto);
        return new FotoOutputDto(foto);
    }

    @Override
    public void borrarFoto(Integer id) throws Exception {
        fotoRepository.delete(fotoRepository.findById(id).orElseThrow());
    }

    @Override
    public FotoOutputDto subirFoto(MultipartFile fileDB, FotoInputDto fotoInputDto) throws IOException {
        Foto foto = new Foto();

        foto.setTitulo(fileDB.getOriginalFilename());
        foto.setFecha(new Date());
        foto.setType(fileDB.getContentType());
        foto.setFileData(fileDB.getBytes());
        foto.setActividad(actividadRepository.findById(fotoInputDto.getIdActividad()).orElseThrow());

        fotoRepository.save(foto);
        return new FotoOutputDto(foto);
    }
}

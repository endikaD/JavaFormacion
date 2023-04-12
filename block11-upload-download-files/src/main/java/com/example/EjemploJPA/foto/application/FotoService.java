package com.example.EjemploJPA.foto.application;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.controller.dto.input.ActividadInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.actividad.controller.dto.output.ActividadOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.input.FotoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.output.FotoOutputDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FotoService {
    //FotoOutputDto añadirFoto(FotoInputDto fotoInputDto);

    FotoOutputDto obtenerFotoPorId(Integer id);

    List<FotoOutputDto> obtenerFotos(Integer pagina, Integer tamanio);

    FotoOutputDto actualizarFoto(MultipartFile fileDB, Integer id, FotoInputDto fotoInputDto) throws IOException;;

    void borrarFoto(Integer id) throws Exception;
    FotoOutputDto subirFoto(MultipartFile multipartFile, FotoInputDto fotoInputDto) throws IOException;
}

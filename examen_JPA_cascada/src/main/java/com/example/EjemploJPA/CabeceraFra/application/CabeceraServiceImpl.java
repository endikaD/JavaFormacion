package com.example.EjemploJPA.CabeceraFra.application;

import com.example.EjemploJPA.CabeceraFra.controller.dto.input.CabeceraInputDto;
import com.example.EjemploJPA.CabeceraFra.controller.dto.output.CabeceraOutputDto;
import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import com.example.EjemploJPA.CabeceraFra.repository.CabeceraRepository;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;
import com.example.EjemploJPA.Cliente.domain.Cliente;
import com.example.EjemploJPA.Cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabeceraServiceImpl implements CabeceraService{
    @Autowired
    CabeceraRepository cabeceraRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public CabeceraOutputDto añadirCabecera(CabeceraInputDto cabeceraInputDto) {
        Cabecera cabecera = cabeceraInputDtoToEntity(cabeceraInputDto);
        cabeceraRepository.save(cabecera);
        return new CabeceraOutputDto(cabecera);
    }

    @Override
    public CabeceraOutputDto obtenerCabeceraPorId(Integer id) {
        Cabecera cabecera = cabeceraRepository.findById(id).orElseThrow();
        return new CabeceraOutputDto(cabecera);
    }

    @Override
    public List<CabeceraOutputDto> obtenerCabeceras() {
        List<Cabecera> cabeceras = cabeceraRepository.findAll();
        return cabeceras.stream().map(CabeceraOutputDto::new).toList();
    }

    @Override
    public CabeceraOutputDto actualizarCabecera(Integer id, CabeceraInputDto cabeceraInputDto){
        Cabecera cabecera = cabeceraRepository.findById(id).orElseThrow();
        cabecera.setImporteFra(cabeceraInputDto.getImporteFra());
        cabecera.setCliente(clienteRepository.findById(cabeceraInputDto.getIdCliente()).orElseThrow());
        cabeceraRepository.save(cabecera);
        return new CabeceraOutputDto(cabecera);
    }

    @Override
    public void borrarCabecera(Integer id){
        cabeceraRepository.delete(cabeceraRepository.findById(id).orElseThrow());
    }
    public Cabecera cabeceraInputDtoToEntity(CabeceraInputDto cabeceraInputDto) {
        Cabecera cabecera = new Cabecera();
        cabecera.setImporteFra(cabeceraInputDto.getImporteFra());
        cabecera.setCliente(clienteRepository.findById(cabeceraInputDto.getIdCliente()).orElseThrow());
        return cabecera;
    }
}

package com.example.EjemploJPA.Cliente.application;

import com.example.EjemploJPA.Cliente.controller.dto.input.ClienteInputDto;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    ClienteOutputDto añadirCliente(ClienteInputDto clienteInputDto);
    ClienteOutputDto obtenerClientePorId(Integer id);
    List<ClienteOutputDto> obtenerClientes();
    ClienteOutputDto actualizarCliente(Integer id, ClienteInputDto clienteInputDto);
    void borrarCliente(Integer id);
}

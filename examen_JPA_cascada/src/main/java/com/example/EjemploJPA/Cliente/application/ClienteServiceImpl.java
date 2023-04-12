package com.example.EjemploJPA.Cliente.application;

import com.example.EjemploJPA.Cliente.controller.dto.input.ClienteInputDto;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;
import com.example.EjemploJPA.Cliente.domain.Cliente;
import com.example.EjemploJPA.Cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ClienteOutputDto añadirCliente(ClienteInputDto clienteInputDto) {
        Cliente cliente = clienteInputDtoToEntity(clienteInputDto);
        clienteRepository.save(cliente);
        return new ClienteOutputDto(cliente);
    }

    @Override
    public ClienteOutputDto obtenerClientePorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return new ClienteOutputDto(cliente);
    }

    @Override
    public List<ClienteOutputDto> obtenerClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteOutputDto::new).toList();
    }

    @Override
    public ClienteOutputDto actualizarCliente(Integer id, ClienteInputDto clienteInputDto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombreCliente(clienteInputDto.getNombreCliente());
        clienteRepository.save(cliente);
        return new ClienteOutputDto(cliente);
    }

    @Override
    public void borrarCliente(Integer id) {
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow());
    }
    public Cliente clienteInputDtoToEntity(ClienteInputDto clienteInputDto) {
        Cliente cliente = new Cliente();
        cliente.setNombreCliente(clienteInputDto.getNombreCliente());
        return cliente;
    }
}

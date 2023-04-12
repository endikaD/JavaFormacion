package com.example.EjemploJPA.Cliente.controller;

import com.example.EjemploJPA.Cliente.application.ClienteService;
import com.example.EjemploJPA.Cliente.controller.dto.input.ClienteInputDto;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ClienteOutputDto añadirCliente(@RequestBody ClienteInputDto clienteInputDto){
        return clienteService.añadirCliente(clienteInputDto);
    }
    @GetMapping("/{id}")
    public ClienteOutputDto obtenerClientePorId(@PathVariable Integer id){
        return clienteService.obtenerClientePorId(id);
    }
    @GetMapping
    public List<ClienteOutputDto> obtenerListaClientes(){
        return clienteService.obtenerClientes();
    }
    @PutMapping("/{id}")
    public ClienteOutputDto actualizarCliente(@PathVariable Integer id, @RequestBody ClienteInputDto clienteInputDto){
        return clienteService.actualizarCliente(id, clienteInputDto);
    }
    @DeleteMapping("/{id}")
    public void borrarCliente(@PathVariable Integer id) throws Exception {
        clienteService.borrarCliente(id);
    }
}

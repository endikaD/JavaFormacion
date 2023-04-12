package com.example.EjemploJPA.Cliente.controller.dto.output;

import com.example.EjemploJPA.Cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDto {
    private Integer idCliente;
    private String nombreCliente;
    public ClienteOutputDto(Cliente cliente){
        setIdCliente(cliente.getIdCliente());
        setNombreCliente(cliente.getNombreCliente());
    }
}

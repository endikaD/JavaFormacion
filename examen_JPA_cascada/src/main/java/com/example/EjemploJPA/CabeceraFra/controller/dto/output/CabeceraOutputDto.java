package com.example.EjemploJPA.CabeceraFra.controller.dto.output;

import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import com.example.EjemploJPA.Cliente.controller.dto.output.ClienteOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraOutputDto {
    private Integer idCabecera;
    private double importeFra;
    private ClienteOutputDto clienteOutputDto;

    public CabeceraOutputDto(Cabecera cabecera){
        setIdCabecera(cabecera.getIdCabecera());
        setImporteFra(cabecera.getImporteFra());
        setClienteOutputDto(new ClienteOutputDto(cabecera.getCliente()));
    }
}

package com.example.EjemploJPA.Cliente.domain;

import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente", nullable = false)
    private int idCliente;
    @Column(name = "nombreCliente", nullable = false, length = 100)
    private String nombreCliente;
    @OneToMany(mappedBy = "cliente")
    private List<Cabecera> cabeceras;

    public Cliente(String nombreCliente) {
        this.nombreCliente=nombreCliente;
    }
}

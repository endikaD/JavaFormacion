package com.example.EjemploJPA.LineasFra.domain;

import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import com.example.EjemploJPA.Cliente.domain.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Lineas")
public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLineas", nullable = false)
    private Integer idLineas;
    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;
    @Column(name = "precio")
    private double precio;
    @Column(name = "cantidad")
    private double cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cabecera")
    private Cabecera cabecera;

    public Linea(String nombreProducto, double precio, double cantidad, Cabecera cabecera) {
        this.nombreProducto = nombreProducto;
        this.cantidad = precio;
        this.precio = cantidad;
        this.cabecera = cabecera;
    }
}

package com.example.EjemploJPA.CabeceraFra.domain;

import com.example.EjemploJPA.Cliente.domain.Cliente;
import com.example.EjemploJPA.LineasFra.domain.Linea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cabecera")
public class Cabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCabecera")
    private Integer idCabecera;
    @Column(name = "importeFra")
    private double importeFra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "cabecera")
    private List<Linea> lineas;

    public Cabecera(int importeFra, Cliente cliente) {
        this.importeFra = importeFra;
        this.cliente = cliente;
    }
}

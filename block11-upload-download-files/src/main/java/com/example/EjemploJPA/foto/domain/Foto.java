package com.example.EjemploJPA.foto.domain;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.domain.Actividad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foto")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_foto", nullable = false)
    private Integer idFoto;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "fileData")
    private byte[] fileData;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_actividad")
//    private Actividad actividad;
}

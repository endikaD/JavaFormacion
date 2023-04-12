package com.example.EjemploJPA.asignatura.domain;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_asignatura")
    private Integer idAsignatura;
    @Column(name = "asignatura")
    private String asignatura;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "fecha_inicial")
    private Date fechaInicial;
    @Column(name = "fechaFinal")
    private Date fechaFinal;
    @ManyToMany(mappedBy = "asignaturas") // CHECKED
    List<Estudiante> estudiantes = new ArrayList<>();
}

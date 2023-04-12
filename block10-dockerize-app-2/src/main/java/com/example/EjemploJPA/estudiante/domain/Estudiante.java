package com.example.EjemploJPA.estudiante.domain;

import com.example.EjemploJPA.asignatura.domain.Asignatura;
import com.example.EjemploJPA.persona.domain.Persona;
import com.example.EjemploJPA.profesor.domain.Profesor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @OneToOne(cascade = CascadeType.ALL) // CHECKED // El estudiante tiene los datos de su correspondiente persona
    @JoinColumn(name = "fk_persona")
    private Persona persona;
    @Column(name = "horas_por_semana")
    private Integer horasPorSemana;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "branch")
    private String branch;
    @ManyToMany
    List<Asignatura> asignaturas= new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_profesor")
    private Profesor profesor;
}

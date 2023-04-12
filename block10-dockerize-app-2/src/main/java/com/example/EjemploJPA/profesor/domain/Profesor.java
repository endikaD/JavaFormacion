package com.example.EjemploJPA.profesor.domain;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.persona.domain.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_profesor")
    private Integer idProfesor;
    @OneToOne(cascade = {CascadeType.ALL}) // CHECKED
    @JoinColumn(name = "fk_persona", unique = true)
    private Persona persona;
    private String comentarios;
    private String branch;
    @OneToMany(mappedBy = "profesor") // CHECKED
    private List<Estudiante> estudiantes;


}

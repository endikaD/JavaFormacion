package com.example.EjemploJPA.persona.domain;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.persona.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.profesor.domain.Profesor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_persona", nullable = false)
    private Integer idPersona;

    @Column(name = "usuario", nullable = false, length = 10)
    private String usuario;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email_compañia", nullable = false)
    private String emailCompañia;

    @Column(name = "email_personal", nullable = false)
    private String emailPersonal;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY) // CHECKED // Una persona tiene asignado un estudiante (o profesor) CHECKED
    private Estudiante estudiante;

    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY)
    private Profesor profesor;
}

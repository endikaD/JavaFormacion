package com.example.EjemploJPA.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //get
    private String nombre; //get
    private Date fechaSubida;
    private String type;
    @Lob
    private byte[] fileData;
}

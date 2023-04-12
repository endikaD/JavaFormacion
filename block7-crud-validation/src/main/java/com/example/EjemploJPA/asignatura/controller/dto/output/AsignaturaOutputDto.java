package com.example.EjemploJPA.asignatura.controller.dto.output;

import com.example.EjemploJPA.asignatura.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutputDto {
    private Integer idAsignatura;
    private String asignatura;
    private String comentarios;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Integer> estudiantes = new ArrayList<>();
    public AsignaturaOutputDto(Asignatura asignatura){
        setIdAsignatura(asignatura.getIdAsignatura());
        setAsignatura(asignatura.getAsignatura());
        setComentarios(asignatura.getComentarios());
        setFechaInicial(asignatura.getFechaFinal());
        setFechaFinal(asignatura.getFechaFinal());

        // set/get para un array
        List<Integer> estudiantes = new ArrayList<>();
        if(asignatura.getEstudiantes().size()!=0){
            for(int i = 0; i < asignatura.getEstudiantes().size(); i++){
                estudiantes.add(asignatura.getEstudiantes().get(i).getIdEstudiante());
            }
        }
        setEstudiantes(estudiantes);
    }
}

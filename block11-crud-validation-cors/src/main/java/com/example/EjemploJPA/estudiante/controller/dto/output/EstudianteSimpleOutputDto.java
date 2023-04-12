package com.example.EjemploJPA.estudiante.controller.dto.output;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteSimpleOutputDto {
    private Integer idEstudiante;
    private Integer idPersona;
    private Integer horasPorSemana;
    private String comentarios;
    private String branch;
    private List<Integer> asignaturas = new ArrayList<>();
    public EstudianteSimpleOutputDto(Estudiante estudiante){
        setIdEstudiante(estudiante.getIdEstudiante());
        setIdPersona(estudiante.getPersona().getIdPersona());
        setHorasPorSemana(estudiante.getHorasPorSemana());
        setComentarios(estudiante.getComentarios());
        setBranch(estudiante.getBranch());


        List<Integer> asignaturas = new ArrayList<>();
        if(estudiante.getAsignaturas() != null) {
            if(estudiante.getAsignaturas().size()!=0){
                for(int i = 0; i < estudiante.getAsignaturas().size(); i++){
                    asignaturas.add(estudiante.getAsignaturas().get(i).getIdAsignatura());
                }
            }
        }
        setAsignaturas(asignaturas);
    }
}

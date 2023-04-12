package com.example.EjemploJPA.asignatura.application;

import com.example.EjemploJPA.asignatura.controller.dto.input.AsignaturaInputDto;
import com.example.EjemploJPA.asignatura.controller.dto.output.AsignaturaOutputDto;
import com.example.EjemploJPA.asignatura.domain.Asignatura;
import com.example.EjemploJPA.asignatura.repository.AsignaturaRepository;
import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.estudiante.repository.EstudianteRepository;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.exceptions.UnprocessableEntityException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    EstudianteRepository estudianteRepository;
    @Override
    public AsignaturaOutputDto añadirAsignatura(AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException {
       Asignatura asignatura = asignaturaInputDtoToEntity(asignaturaInputDto);
       asignaturaRepository.save(asignatura);
       AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto(asignatura);
       return asignaturaOutputDto;
    }

    @Override
    public AsignaturaOutputDto obtenerAsignaturaPorId(Integer id) throws EntityNotFoundException {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now()));//new date
        return new AsignaturaOutputDto(asignatura);
    }

    @Override
    public List<AsignaturaOutputDto> obtenerAsignaturas() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        return asignaturas.stream().map(AsignaturaOutputDto::new).toList();
    }

    @Override
    public AsignaturaOutputDto actualizarAsignatura(Integer id, AsignaturaInputDto asignaturaInputDto) throws Exception {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now()));

        asignatura.setAsignatura(asignaturaInputDto.getAsignatura());
        asignatura.setComentarios(asignaturaInputDto.getComentarios());
        asignatura.setFechaInicial(asignaturaInputDto.getFechaInicial());
        asignatura.setFechaFinal(asignaturaInputDto.getFechaFinal());

        asignaturaRepository.save(asignatura);
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto(asignatura);
        return asignaturaOutputDto;
    }

    @Override
    public void borrarAsignatura(Integer id) throws Exception {
        asignaturaRepository.delete(asignaturaRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now())));
    }

    @Override
    public void añadirAsignaturaAEstudiante(int idAsignatura, int idEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow();
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).orElseThrow();
        estudiante.getAsignaturas().add(asignatura);
        estudianteRepository.save(estudiante);
    }

    private Asignatura asignaturaInputDtoToEntity(AsignaturaInputDto asignaturaInputDto){
        Asignatura asignatura = new Asignatura();
        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < asignaturaInputDto.getEstudiantes().size(); i++) {
            estudiantes.add(estudianteRepository.findById(asignaturaInputDto.getEstudiantes().get(i)).orElseThrow());
        }
        asignatura.setEstudiantes(estudiantes);

        asignatura.setAsignatura(asignaturaInputDto.getAsignatura());
        asignatura.setComentarios(asignaturaInputDto.getComentarios());
        asignatura.setFechaInicial(asignaturaInputDto.getFechaInicial());
        asignatura.setFechaFinal(asignaturaInputDto.getFechaFinal());

        return asignatura;

    }
}

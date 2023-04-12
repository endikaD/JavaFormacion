package com.example.EjemploJPA.estudiante.application;

import com.example.EjemploJPA.asignatura.domain.Asignatura;
import com.example.EjemploJPA.asignatura.repository.AsignaturaRepository;
import com.example.EjemploJPA.estudiante.controller.dto.input.EstudianteInputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteFullOutputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteOutputDto;
import com.example.EjemploJPA.estudiante.controller.dto.output.EstudianteSimpleOutputDto;
import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.estudiante.repository.EstudianteRepository;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.exceptions.UnprocessableEntityException;
import com.example.EjemploJPA.persona.repository.PersonaRepository;
import com.example.EjemploJPA.profesor.domain.Profesor;
import com.example.EjemploJPA.profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class EstudianteServiceImpl implements EstudianteService{
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public EstudianteOutputDto añadirEstudiante(EstudianteInputDto estudianteInputDto) throws Exception {
        List<Profesor> profesores = profesorRepository.findAll();
        for (int i = 0; i < profesores.size(); i++){
            if(estudianteInputDto.getIdPersona().equals(profesores.get(i).getPersona().getIdPersona())){
                throw new Exception(estudianteInputDto.getIdPersona()+ " es un estudiante");
            }
        }
        Estudiante estudiante = estudianteInputDtoToEntity(estudianteInputDto);
        estudianteRepository.save(estudiante);
        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudiante);
        return estudianteOutputDto;
    }

    @Override
    public EstudianteSimpleOutputDto obtenerEstudianteSimplePorId(Integer id, String outputType) throws EntityNotFoundException {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now()));
        EstudianteSimpleOutputDto estudianteSimpleOutputDto = new EstudianteSimpleOutputDto(estudiante);
        return estudianteSimpleOutputDto;
    }

    @Override
    public EstudianteFullOutputDto obtenerEstudianteFullPorId(Integer id, String outputType) throws EntityNotFoundException {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now()));
        EstudianteFullOutputDto estudianteFullOutputDto  = new EstudianteFullOutputDto(estudiante);
        return estudianteFullOutputDto;
    }

    @Override
    public List<EstudianteOutputDto> obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream().map(EstudianteOutputDto::new).toList();
    }

    @Override
    public EstudianteOutputDto actualizarEstudiante(Integer id, EstudianteInputDto estudianteInputDto) throws Exception {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow();

        estudiante.setPersona(personaRepository.findById(estudianteInputDto.getIdPersona()).orElseThrow());
        estudiante.setProfesor(profesorRepository.findById(estudianteInputDto.getIdProfesor()).orElseThrow());
        estudiante.setHorasPorSemana(estudianteInputDto.getHorasPorSemana());
        estudiante.setComentarios(estudianteInputDto.getComentarios());
        estudiante.setBranch(estudianteInputDto.getBranch());

        if (estudianteInputDto.getAsignaturas()!=null)
        {
            List<Asignatura> asignaturas=new ArrayList<>();
            for (int asignatura: estudianteInputDto.getAsignaturas())
            {
                Asignatura asignatura1= asignaturaRepository.findById(asignatura).orElseThrow();
                asignaturas.add(asignatura1);
            }
            estudiante.setAsignaturas(asignaturas);
        }

        estudianteRepository.save(estudiante);
        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudiante);
        return estudianteOutputDto;
    }

    @Override
    public void borrarEstudiante(Integer id) throws Exception {
        estudianteRepository.delete(estudianteRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now())));
    }
    private Estudiante estudianteInputDtoToEntity(EstudianteInputDto estudianteInputDto){
        Estudiante estudiante = new Estudiante();

        estudiante.setPersona(personaRepository.findById(estudianteInputDto.getIdPersona()).orElseThrow());
        estudiante.setProfesor(profesorRepository.findById(estudianteInputDto.getIdProfesor()).orElseThrow());
        estudiante.setHorasPorSemana(estudianteInputDto.getHorasPorSemana());
        estudiante.setComentarios(estudianteInputDto.getComentarios());
        estudiante.setBranch(estudianteInputDto.getBranch());
        if (estudianteInputDto.getAsignaturas()!=null)
        {
            List<Asignatura> asignaturas=new ArrayList<>();
            for (int asignatura: estudianteInputDto.getAsignaturas())
            {
                Asignatura asignatura1= asignaturaRepository.findById(asignatura).orElseThrow();
                asignaturas.add(asignatura1);
            }
            estudiante.setAsignaturas(asignaturas);
        }
        return estudiante;
    }
}

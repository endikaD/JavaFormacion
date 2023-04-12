package com.example.EjemploJPA.profesor.application;

import com.example.EjemploJPA.estudiante.domain.Estudiante;
import com.example.EjemploJPA.estudiante.repository.EstudianteRepository;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.exceptions.UnprocessableEntityException;
import com.example.EjemploJPA.persona.repository.PersonaRepository;
import com.example.EjemploJPA.profesor.controller.dto.input.ProfesorInputDto;
import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;
import com.example.EjemploJPA.profesor.domain.Profesor;
import com.example.EjemploJPA.profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public ProfesorOutputDto añadirProfesor(ProfesorInputDto profesorInputDto) throws Exception {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        for (int i = 0; i < estudiantes.size(); i++){
            if(profesorInputDto.getIdPersona().equals(estudiantes.get(i).getPersona().getIdPersona())){
                throw new Exception(profesorInputDto.getIdPersona()+ " es un estudiante");
            }
        }
        Profesor profesor = profesorInputDtoToEntity(profesorInputDto);
        profesorRepository.save(profesor);
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesor);
        return profesorOutputDto;
    }

    @Override
    public ProfesorOutputDto obtenerProfesorPorId(Integer id) throws EntityNotFoundException {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now()));//new date
        return new ProfesorOutputDto(profesor);
    }

    @Override
    public List<ProfesorOutputDto> obtenerProfesores() {
        List<Profesor> profesor = profesorRepository.findAll();
        return profesor.stream().map(ProfesorOutputDto::new).toList();
    }

    @Override
    public ProfesorOutputDto actualizarProfesor(Integer id, ProfesorInputDto profesorInputDto) throws Exception {
            Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now()));

            profesor.setPersona(personaRepository.findById(profesorInputDto.getIdPersona()).orElseThrow(()->new Exception("Persona no encontrada")));
            profesor.setComentarios(profesorInputDto.getComments());
            profesor.setBranch(profesorInputDto.getBranch());

            profesorRepository.save(profesor);
            ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesor);
            return profesorOutputDto;

    }

    @Override
    public void borrarProfesor(Integer id) throws Exception {
        profesorRepository.delete(profesorRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now())));
    }

    private Profesor profesorInputDtoToEntity(ProfesorInputDto profesorInputDto){
        Profesor profesor = new Profesor();
        profesor.setPersona(personaRepository.findById(profesorInputDto.getIdPersona()).orElseThrow());
        profesor.setComentarios(profesorInputDto.getComments());
        profesor.setBranch(profesorInputDto.getBranch());

        return profesor;
    }
}

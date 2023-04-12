package com.example.EjemploJPA.persona.application;

import com.example.EjemploJPA.persona.controller.PersonaController;
import com.example.EjemploJPA.persona.controller.dto.QueryDto;
import com.example.EjemploJPA.persona.controller.dto.input.PersonaInputDto;
import com.example.EjemploJPA.persona.controller.dto.output.PersonaOutputDto;
import com.example.EjemploJPA.persona.domain.Persona;
import com.example.EjemploJPA.exceptions.EntityNotFoundException;
import com.example.EjemploJPA.exceptions.UnprocessableEntityException;
import com.example.EjemploJPA.persona.repository.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto) throws EntityNotFoundException {
        /*
        if (personaRepository.findByUsuario(personaInputDto.getUsuario()) == null) {
            Persona persona = personaInputDtoToEntity(personaInputDto);
            persona.setId(persona.getId());
            personaRepository.save(persona);

            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
            return personaOutputDto;
        }
        System.out.println("Este nombre de usuario ya está cogido");
        return null;

         */
        if (personaRepository.findByUsuario(personaInputDto.getUsuario()) == null) {
            Persona persona = personaInputDtoToEntity(personaInputDto);
            personaRepository.save(persona); //se guarda en repo
            return new PersonaOutputDto(persona); //se devuelve
        } else {
            throw new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now());
        }
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorUsuario(String usuario) {
        Persona persona = personaRepository.findByUsuario(usuario);
        return new PersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorId(Integer id) throws EntityNotFoundException {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("\nNo existe.", 404, LocalDateTime.now()));
        return new PersonaOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> obtenerPersonas() {
        List<Persona> clients = personaRepository.findAll();
        return clients.stream().map(PersonaOutputDto::new).toList();
    }

    @Override
    public PersonaOutputDto actualizarPersona(Integer id, PersonaInputDto personaInputDto) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now()));
        //falta utils
        persona.setUsuario(personaInputDto.getUsuario());
        persona.setContraseña(personaInputDto.getContraseña());
        persona.setNombre(personaInputDto.getNombre());
        persona.setApellido(personaInputDto.getApellido());
        persona.setEmailCompañia(personaInputDto.getEmailCompañia());
        persona.setEmailPersonal(personaInputDto.getEmailCompañia());
        persona.setCity(personaInputDto.getCity());
        persona.setActivo(personaInputDto.isActivo());
        persona.setFechaCreacion(personaInputDto.getFechaCreacion());
        persona.setUrlImagen(personaInputDto.getUrlImagen());
        persona.setFechaFinalizacion(personaInputDto.getFechaFinalizacion());

        personaRepository.save(persona);
        PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
        return personaOutputDto;
    }

    @Override
    public void borrarPersona(Integer id) throws Exception {
        personaRepository.delete(personaRepository.findById(id).orElseThrow(() -> new UnprocessableEntityException("\nNo existe.", 404, LocalDateTime.now())));
    }

    public Persona personaInputDtoToEntity(PersonaInputDto personaInputDto) {
        Persona persona = new Persona();
        persona.setUsuario(personaInputDto.getUsuario());
        persona.setContraseña(personaInputDto.getContraseña());
        persona.setNombre(personaInputDto.getNombre());
        persona.setApellido(personaInputDto.getApellido());
        persona.setEmailCompañia(personaInputDto.getEmailCompañia());
        persona.setEmailPersonal(personaInputDto.getEmailCompañia());
        persona.setCity(personaInputDto.getCity());
        persona.setActivo(personaInputDto.isActivo());
        persona.setFechaCreacion(personaInputDto.getFechaCreacion());
        persona.setUrlImagen(personaInputDto.getUrlImagen());
        persona.setFechaFinalizacion(personaInputDto.getFechaFinalizacion());

        return persona;
    }

    @PersistenceContext //Es parecido a un Autowired
    private EntityManager entityManager;


    @Override
    public List<PersonaOutputDto> criteriaPersonas(QueryDto queryDto) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder(); //Se construye el objeto para la consulta
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class); //Se utiliza para la ejecucion de la consulta
        Root<Persona> root = query.from(Persona.class); //La entidad que se va a consultar
        List<Predicate> predicates = new ArrayList<>(); // PREDICATE = CONDICIONES //linkedlist

        if (queryDto.getUsuario() != null) {//                                                                |
            predicates.add(cb.equal(root.get("usuario"), queryDto.getUsuario())); // Añadir      // con el root.get va al modelo y coge su atributo              |
        }
        if (queryDto.getNombre() != null) {
            predicates.add(cb.equal(root.get("nombre"), queryDto.getNombre()));

        }
        if (queryDto.getApellido() != null) {
            predicates.add(cb.equal(root.get("apellido"), queryDto.getApellido()));

        }
        if (queryDto.getDateCondition() != null) {
            if (queryDto.getDateCondition() != null && queryDto.getDateCondition().equals("more")) {                // Condiciones para la fecha dependiendo
                predicates.add(cb.greaterThan(root.get(("fechaCreacion")), queryDto.getFechaCreacion()));  // de si es mayor, menor o igual
            } else if (queryDto.getDateCondition() != null && queryDto.getDateCondition().equals("less")) {
                predicates.add(cb.lessThan(root.get(("fechaCreacion")), queryDto.getFechaCreacion()));
            } else {
                predicates.add(cb.equal(root.get(("fechaCreacion")), queryDto.getFechaCreacion()));
            }
        }

        if (queryDto.getCampo() != null) {
            query.orderBy(cb.asc(root.get(getCampo(queryDto.getCampo())))); // Ordenar ascendentemente por campo
        }

        if (predicates != null && predicates.size() != 0) {
            query.where(predicates.toArray(new Predicate[predicates.size()])); // La query con los valores deseados arriba
        }

        List<PersonaOutputDto> personaOutputDtoList = new ArrayList<>();

        List<Persona> personas = entityManager.createQuery(query).getResultList();

//        for (Persona p : personas) {
//            personaOutputDtoList.add(new PersonaOutputDto(p));
//        }

        personas.forEach(p -> personaOutputDtoList.add(new PersonaOutputDto(p))); // Lo mismo que lo de arriba pero con un Lambda

        //Function <PersonaOutputDto, ?> function = p -> personaOutputDtoList.add(p);   // Lo mismo que lo de arriba pero con un Function

        //personas.forEach(p -> System.out.println(p));     Forma 1
        //personas.forEach(System.out::println);            Forma 2

        PagedListHolder<PersonaOutputDto> pagedListHolder = new PagedListHolder<>(personaOutputDtoList);
        pagedListHolder.setPage(queryDto.getPagina() != null ? queryDto.getPagina() : 0); //Si se cumple la condicion y sino la alternativa
        pagedListHolder.setPageSize(queryDto.getTamaño() != null ? queryDto.getTamaño() : 10);


        return pagedListHolder.getPageList();
    }

    private String getCampo(Integer campo) {
        if (campo.equals(Campos.usuario)) return "usuario";
        if (campo.equals(Campos.nombre)) return "nombre";
        if (campo.equals(Campos.apellido)) return "apellido";
        return "usuario";

//        switch (campo){
//            case Campos.usuario : return "usuario";
//            case Campos.nombre: return "nombre";
//            case Campos.apellido: return "apellido";
//            default: return "usuario";
//        }

    }
}

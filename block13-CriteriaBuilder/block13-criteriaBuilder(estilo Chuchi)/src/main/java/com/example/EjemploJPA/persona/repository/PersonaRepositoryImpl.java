package com.example.EjemploJPA.persona.repository;

import com.example.EjemploJPA.persona.domain.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.example.EjemploJPA.persona.controller.PersonaController.*;

public class PersonaRepositoryImpl { //Obligatorio que el nombre de la clase sea igual al repositorio +Impl
    @PersistenceContext //Es parecido a un Autowired
    private EntityManager entityManager;
    public List<Persona> getData(HashMap<String, Object> conditions)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query= cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {
                case "usuario":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    query.orderBy(cb.asc(root.get("usuario")));
                    break;
                case "nombre":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    query.orderBy(cb.asc(root.get("nombre")));
                    break;
                case "apellido":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "fechaCreacion":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case GREATER_THAN:
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case LESS_THAN:
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case EQUAL:
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }

        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}

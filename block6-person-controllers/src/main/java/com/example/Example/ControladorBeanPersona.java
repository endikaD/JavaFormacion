package com.example.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBeanPersona {
    @Autowired
    @Qualifier("primeroBean")
    Persona primeraPersona;

    @Autowired
    @Qualifier("segundoBean")
    Persona segundaPersona;

    @Autowired
    @Qualifier("terceroBean")
    Persona terceraPersona;

    @GetMapping("/controlador/bean/{bean}")
    public Persona getBeansPersona(@PathVariable String bean) {
        if (bean.equalsIgnoreCase("primeroBean")) {
            return primeraPersona;
        } else if (bean.equalsIgnoreCase("segundoBean")) {
            return segundaPersona;
        } else if (bean.equalsIgnoreCase("terceroBean")) {
            return terceraPersona;
        }
        return null;

    }
}

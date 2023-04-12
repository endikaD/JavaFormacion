package com.ejercicio.logging.block5logging;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController  {
    @PostMapping("/")
    public String index(){
        log.trace("Mensaje TRACE");
        log.debug("Mensaje DEBUG");
        log.info("Mensaje INFO");
        log.warn("Mensaje WARNING");
        log.error("Mensaje ERROR");
        return "Errores:";
    }
}

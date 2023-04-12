package com.ejercicio.logging.block5logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class Block5LoggingApplication   {
	public static void main(String[] args)  {
		SpringApplication.run(Block5LoggingApplication.class, args);
		log.trace("Mensaje TRACE");
		log.debug("Mensaje DEBUG");
		log.info("Mensaje INFO");
		log.warn("Mensaje WARNING");
		log.error("Mensaje ERROR");
	}
}

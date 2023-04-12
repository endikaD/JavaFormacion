package com.example.EjemploJPA;

import com.example.EjemploJPA.CabeceraFra.domain.Cabecera;
import com.example.EjemploJPA.CabeceraFra.repository.CabeceraRepository;
import com.example.EjemploJPA.Cliente.domain.Cliente;
import com.example.EjemploJPA.Cliente.repository.ClienteRepository;
import com.example.EjemploJPA.LineasFra.domain.Linea;
import com.example.EjemploJPA.LineasFra.repository.LineasRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EjemploJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(EjemploJpaApplication.class, args);

		ClienteRepository clienteRepository = configurableApplicationContext.getBean(ClienteRepository.class);
		Cliente cliente = new Cliente("Endika");
		clienteRepository.save(cliente);

		CabeceraRepository cabeceraRepository = configurableApplicationContext.getBean(CabeceraRepository.class);
		Cabecera cabecera = new Cabecera(2, cliente);
		cabeceraRepository.save(cabecera);

		LineasRepository lineasRepository = configurableApplicationContext.getBean(LineasRepository.class);
		Linea linea1 = new Linea("Boli", 0.5, 2, cabecera);
		Linea linea2 = new Linea("Lapiz", 0.75, 3, cabecera);

		List<Linea> lineasFra = Arrays.asList(linea1, linea2);
		lineasRepository.saveAll(lineasFra);
	}

}

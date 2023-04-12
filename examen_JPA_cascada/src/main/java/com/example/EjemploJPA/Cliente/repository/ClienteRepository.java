package com.example.EjemploJPA.Cliente.repository;

import com.example.EjemploJPA.Cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

package com.example.EjemploJPA.feign;

import com.example.EjemploJPA.profesor.controller.dto.output.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@FeignClient(url="http://localhost:8081",name = "profesorFeign")
public interface Feign {
    @GetMapping("/profesor/{id}")
    ResponseEntity<ProfesorOutputDto> callServer(@PathVariable("id") Integer id);
}

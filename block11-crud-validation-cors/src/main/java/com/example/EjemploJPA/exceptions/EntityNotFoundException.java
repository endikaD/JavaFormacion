package com.example.EjemploJPA.exceptions;

import java.time.LocalDateTime;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message, int httpCode, LocalDateTime timestamp) {
        super("\nProblema: "+message+"\nCodigo:"+httpCode+"\nHora:"+timestamp);
    }
}

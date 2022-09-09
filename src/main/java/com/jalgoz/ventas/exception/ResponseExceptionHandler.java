package com.jalgoz.ventas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// Aquí manejaremos las excepciones que puedan aparecer en cliente controller
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    // Retornamos ResponseEntity porque en ClienteController todos los métodos son ResponseEntity
    @ExceptionHandler(Exception.class) // Para decirle que manejará la excepciones cómunes
    public final ResponseEntity<ExceptionResponse> handlerException(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Ocurrió un error",
                e.getMessage()
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

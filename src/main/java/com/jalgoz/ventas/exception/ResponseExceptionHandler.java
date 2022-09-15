package com.jalgoz.ventas.exception;

import com.jalgoz.ventas.VentasApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Aquí manejaremos las excepciones que puedan aparecer en cliente controller
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    // Para mostrar los Log's
    private static final Logger logger = LoggerFactory.getLogger(VentasApplication.class);

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

    // Para manejar todos las excepcioens
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("Mi primer log");

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Creamos el map de los errores para que nos muestré más detallado al momento de saltar errores en la validación
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        // Terminamos mandando el error al validar con el map ya llenó
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Ocurrió un error",
                ex.getMessage(),
                errors
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

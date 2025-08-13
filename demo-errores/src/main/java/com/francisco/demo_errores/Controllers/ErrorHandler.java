package com.francisco.demo_errores.Controllers;

import com.francisco.demo_errores.Models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<?> divisionByCero(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(error);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFound(NoHandlerFoundException e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("API REST no encontrada");
        error.setMessage(e.getMessage()); // Aquí usas el mensaje real del error
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // Devuelves el error como cuerpo
    }
    @ExceptionHandler(NumberFormatException.class)

    public Map<String, String>numberFormatException(Exception e){
        Map<String, String>error = new HashMap();
        error.put("date", new Date().toString());
        error.put("error","numero invalido e incorrecto");
        error.put("message", e.getMessage());
        error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return error;
    }

}

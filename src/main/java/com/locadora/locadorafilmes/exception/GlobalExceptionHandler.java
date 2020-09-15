package com.locadora.locadorafilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomGenericException.class)
    public ResponseEntity<CustomErrorResponse> handle(Exception e, WebRequest request){
        CustomErrorResponse error = new CustomErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(formattedTimestamp());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    private String formattedTimestamp() {
        // Obtém LocalDateTime de now
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedNow = now.format(formatter);
        return formattedNow;
    }
}
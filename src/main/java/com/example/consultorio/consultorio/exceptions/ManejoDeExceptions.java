package com.example.consultorio.consultorio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejoDeExceptions {
    
    @ExceptionHandler(DniExistenteException.class)
    public ResponseEntity<String> handleDniExistenteException(DniExistenteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DniInvalidoException.class)
    public ResponseEntity<String> handleDniInvalidoException(DniInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailExistenteException.class)
    public ResponseEntity<String> handleEmailExistenteException(EmailExistenteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailInvalidoException.class)
    public ResponseEntity<String> handleEmailInvalidoException(EmailInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NombreInvalidoException.class)
    public ResponseEntity<String> handleNombreInvalidoException(NombreInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TelefonoInvalidoException.class)
    public ResponseEntity<String> handleTelefonoInvalidoException(TelefonoInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
}

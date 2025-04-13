package com.example.consultorio.consultorio.exceptions;

public class EmailExistenteException extends Exception{

    public EmailExistenteException(String email){
        super("El email:" + email+" ya esta registrado en la base de datos");
    }
}

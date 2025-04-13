package com.example.consultorio.consultorio.exceptions;

public class EmailInvalidoException extends Exception{

    public EmailInvalidoException(String email) {
        super("El email:"+email+" es invalido");
    }

}

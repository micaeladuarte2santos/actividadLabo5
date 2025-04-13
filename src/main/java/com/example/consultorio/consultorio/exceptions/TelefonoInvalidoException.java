package com.example.consultorio.consultorio.exceptions;

public class TelefonoInvalidoException extends Exception{

    public TelefonoInvalidoException(String telefono) {
        super("El telefono:" +telefono+" es invalido");
    }

}

package com.example.consultorio.consultorio.exceptions;

public class NombreInvalidoException extends Exception{

    public NombreInvalidoException(String nombre) {
        super("El nombre:"+nombre+" es invalido");

    }

}

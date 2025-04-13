package com.example.consultorio.consultorio.exceptions;

public class DniInvalidoException extends Exception{

    public DniInvalidoException(String dni){
        super("El dni:"+dni+" es invalido");
    }
}

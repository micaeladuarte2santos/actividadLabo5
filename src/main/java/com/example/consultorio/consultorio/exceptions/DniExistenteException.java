package com.example.consultorio.consultorio.exceptions;

public class DniExistenteException extends Exception{

    public DniExistenteException(String dni){
        super("El dni:"+dni+" ya existe en la base de datos");
    }
}

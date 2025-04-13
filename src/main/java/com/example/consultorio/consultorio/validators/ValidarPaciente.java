package com.example.consultorio.consultorio.validators;

import org.springframework.stereotype.Component;

import com.example.consultorio.consultorio.exceptions.DniInvalidoException;
import com.example.consultorio.consultorio.exceptions.EmailInvalidoException;
import com.example.consultorio.consultorio.exceptions.NombreInvalidoException;
import com.example.consultorio.consultorio.exceptions.TelefonoInvalidoException;

@Component
public class ValidarPaciente {

    public void validar(String dni, String nombre, String email,String telefono){
        if(!dni.matches("\\d{8}")) {
			throw new DniInvalidoException(dni);
		}
		
		if(!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
			throw new NombreInvalidoException(nombre);
		}
		
		if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new EmailInvalidoException(email);
		}
		
		if(!telefono.matches("\\d+")) {
			throw new TelefonoInvalidoException(telefono);
		}
    }
}

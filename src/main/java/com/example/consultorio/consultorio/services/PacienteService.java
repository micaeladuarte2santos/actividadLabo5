package com.example.consultorio.consultorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.consultorio.consultorio.exceptions.DniExistenteException;
import com.example.consultorio.consultorio.exceptions.EmailExistenteException;
import com.example.consultorio.consultorio.models.Paciente;
import com.example.consultorio.consultorio.repositories.PacienteRepository;
import com.example.consultorio.consultorio.validators.ValidarPaciente;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ValidarPaciente validarPaciente;    

    @Transactional
    public Paciente agregarPaciente(String dni, String nombre, String email, String telefono){

        validarPaciente.validar(dni, nombre, email, telefono);

        if(pacienteRepository.findByDni(dni).isPresent()){
            throw new DniExistenteException(dni);
        }

        if(pacienteRepository.findByEmail(email).isPresent()){
            throw new EmailExistenteException(email);
        }         

        Paciente pac = new Paciente();
        pac.setDni(dni);
        pac.setNombre(nombre);
        pac.setEmail(email);
        pac.setTelefono(telefono);


        Paciente nuevoPaciente=pacienteRepository.save(pac);
        return nuevoPaciente;
    }
}

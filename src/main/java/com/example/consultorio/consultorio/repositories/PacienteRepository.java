package com.example.consultorio.consultorio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.consultorio.consultorio.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,String>{

    public Optional<Paciente> findByDni(String dni);

    public Optional<Paciente> findByEmail(String email);

}

package com.example.consultorio.consultorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultorio.consultorio.models.Paciente;
import com.example.consultorio.consultorio.services.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(String dni, String nombre, String email, String telefono){
        return ResponseEntity.ok(pacienteService.agregarPaciente(dni,nombre,email,telefono));
    }
}

package com.example.consultorio.consultorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.consultorio.consultorio.exceptions.DniExistenteException;
import com.example.consultorio.consultorio.exceptions.EmailExistenteException;
import com.example.consultorio.consultorio.models.Paciente;
import com.example.consultorio.consultorio.repositories.PacienteRepository;
import com.example.consultorio.consultorio.services.PacienteService;
import com.example.consultorio.consultorio.validators.ValidarPaciente;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;
    
    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private ValidarPaciente validarPaciente;

    private String dni = "12345678";
    private String nombre = "Juan Pérez";
    private String email = "juan@example.com";
    private String telefono = "123456789";

    @BeforeEach
    void setup() {

    }

    @Test
    public void agregarPaciente_DeberiaGuardarPaciente_CuandoNoExiste() {
        // Configuración del mock
        when(pacienteRepository.findByDni(dni)).thenReturn(Optional.empty());
        when(pacienteRepository.findByEmail(email)).thenReturn(Optional.empty());

        Paciente pacienteGuardado = new Paciente();
        pacienteGuardado.setDni(dni);
        pacienteGuardado.setNombre(nombre);
        pacienteGuardado.setEmail(email);
        pacienteGuardado.setTelefono(telefono);

        when(pacienteRepository.save(any(Paciente.class))).thenReturn(pacienteGuardado);

        // Ejecución
        Paciente resultado = pacienteService.agregarPaciente(dni, nombre, email, telefono);

        // Verificación
        assertNotNull(resultado);
        assertEquals(dni, resultado.getDni());
        assertEquals(nombre, resultado.getNombre());
        assertEquals(email, resultado.getEmail());
        assertEquals(telefono, resultado.getTelefono());

        verify(validarPaciente).validar(dni, nombre, email, telefono);
        verify(pacienteRepository).save(any(Paciente.class));
    }

    @Test
    public void agregarPaciente_DeberiaLanzarExcepcion_SiDniYaExiste() {
        when(pacienteRepository.findByDni(dni)).thenReturn(Optional.of(new Paciente()));

        assertThrows(DniExistenteException.class, () -> {
            pacienteService.agregarPaciente(dni, nombre, email, telefono);
        });

        verify(pacienteRepository).findByDni(dni);
        verify(pacienteRepository, never()).save(any());
    }

    @Test
    public void agregarPaciente_DeberiaLanzarExcepcion_SiEmailYaExiste() {
        when(pacienteRepository.findByDni(dni)).thenReturn(Optional.empty());
        when(pacienteRepository.findByEmail(email)).thenReturn(Optional.of(new Paciente()));

        assertThrows(EmailExistenteException.class, () -> {
            pacienteService.agregarPaciente(dni, nombre, email, telefono);
        });

        verify(pacienteRepository).findByEmail(email);
        verify(pacienteRepository, never()).save(any());
    }
}

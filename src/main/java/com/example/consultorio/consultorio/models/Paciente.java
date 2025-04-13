package com.example.consultorio.consultorio.models;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
 
    @Id
    private String dni;
    private String nombre;
    private String email;
    private String telefono;

}

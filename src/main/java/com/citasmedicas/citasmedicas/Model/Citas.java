package com.citasmedicas.citasmedicas.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "citas")
public class Citas {

    private static final Logger logger = Logger.getLogger(Citas.class.getName());



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombreDoctor")
    private String nombrePaciente;
    @Column(name = "nombrePaciente")
    private String fechaCita;

    //Getters and Setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        if (id == null) {
            logger.log(Level.SEVERE, "El ID no puede ser nulo");
        }
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        if (nombrePaciente == null || nombrePaciente.isEmpty()) {
            logger.log(Level.SEVERE, "El nombre del paciente no puede ser nulo o vacío");
        }
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        if (fechaCita == null || fechaCita.isEmpty()) {
            logger.log(Level.SEVERE, "La fecha de la cita no puede ser nula o vacía");
        }
        this.fechaCita = fechaCita;
    }

}

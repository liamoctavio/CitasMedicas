package com.citasmedicas.citasmedicas.Service;

import java.util.List;
import java.util.Optional;
import com.citasmedicas.citasmedicas.Model.Citas;

public interface CitasService {

    List<Citas> findAll();
    Optional<Citas> findById(Long id);
    Citas save(Citas cita);
    Citas updateCitas(Long id, Citas cita);
    void deleteCitas(Long id); 
}

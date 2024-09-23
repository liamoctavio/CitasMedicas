package com.citasmedicas.citasmedicas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.citasmedicas.citasmedicas.Model.Citas;
import com.citasmedicas.citasmedicas.Repository.CitasRepository;

@Service
public class CitasServicelmpl implements CitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Override
    public List<Citas> findAll() {
        return citasRepository.findAll();
    }

    @Override
    public Optional<Citas> findById(Long id) {
        return citasRepository.findById(id);
    }

    @Override
    public Citas save(Citas cita) {
        return citasRepository.save(cita);
    }

    @Override
    public Citas updateCitas(Long id, Citas cita) {
        if(citasRepository.existsById(id)){
            cita.setId(id);
            return citasRepository.save(cita);
        }else{
            return null;
        }
    }

    @Override
    public void deleteCitas(Long id) {
        citasRepository.deleteById(id);
    }

}

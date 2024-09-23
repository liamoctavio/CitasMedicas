package com.citasmedicas.citasmedicas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.citasmedicas.citasmedicas.Model.Citas;

public interface CitasRepository extends JpaRepository<Citas, Long> {

    

}

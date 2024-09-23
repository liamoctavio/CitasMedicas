package com.citasmedicas.citasmedicas.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasmedicas.citasmedicas.Service.CitasService;
import com.citasmedicas.citasmedicas.Model.Citas;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/citas")
public class CitasController {

    private static final Logger logger = Logger.getLogger(CitasController.class.getName());


    @Autowired
    private CitasService citasService;

    @GetMapping
    public List<Citas> findAll() {
        logger.log(Level.INFO, "Obteniendo datos de citas");
        return citasService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Citas> findById(@PathVariable("id") Long id) {
        logger.log(Level.INFO, "Obteniendo datos con id: {0}", id);
        return citasService.findById(id);
    }

    @PostMapping
    public Citas save(@RequestBody Citas citas) {
        logger.log(Level.INFO, "Guardando datos: {0}", citas);
        return citasService.save(citas);
    }

    @PutMapping("/{id}")
    public Citas updateCitas(@PathVariable Long id, @RequestBody Citas citas) {   
        logger.log(Level.INFO, "Actualizando datos con id: {0}", id);     
        return citasService.updateCitas(id, citas);
    }

    @DeleteMapping("/{id}")
    public void deleteCitas(@PathVariable Long id) {
        logger.log(Level.INFO, "Borrando datos con id: {0}", id);
        citasService.deleteCitas(id);
    }
    


}

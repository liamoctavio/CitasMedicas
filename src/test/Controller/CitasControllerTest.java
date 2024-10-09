package com.example.mascotas.Controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.example.mascotas.Service.CitasService;

import com.example.mascotas.Model.Citas; // Import the Citas class


public class CitasControllerTest {

    @Mock
    private CitasService citasService;

    @InjectMocks
    private CitasController citasController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Citas citas = new Citas();
        when(citasService.save(citas)).thenReturn(citas);

        Citas result = citasController.save(citas);

        assertEquals(citas, result);
        verify(citasService, times(1)).save(citas);
    }

    @Test
    public void testUpdateCitas() {
        Long id = 1L;
        Citas citas = new Citas();
        when(citasService.updateCitas(id, citas)).thenReturn(citas);

        Citas result = citasController.updateCitas(id, citas);

        assertEquals(citas, result);
        verify(citasService, times(1)).updateCitas(id, citas);
    }

    @Test
    public void testDeleteCitas() {
        Long id = 1L;

        citasController.deleteCitas(id);

        verify(citasService, times(1)).deleteCitas(id);
    }
}



package com.citasmedicas.citasmedicas.Service;

import com.citasmedicas.citasmedicas.Model.Citas;
import com.citasmedicas.citasmedicas.Repository.CitasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



public class CitasServiceTest {

    @Mock
    private CitasRepository citasRepository;

    @InjectMocks
    private CitasServicelmpl citasService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Citas cita1 = new Citas();
        Citas cita2 = new Citas();
        when(citasRepository.findAll()).thenReturn(Arrays.asList(cita1, cita2));

        List<Citas> result = citasService.findAll();
        assertEquals(2, result.size());
        verify(citasRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Citas cita = new Citas();
        when(citasRepository.findById(1L)).thenReturn(Optional.of(cita));

        Optional<Citas> result = citasService.findById(1L);
        assertTrue(result.isPresent());
        verify(citasRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Citas cita = new Citas();
        when(citasRepository.save(cita)).thenReturn(cita);

        Citas result = citasService.save(cita);
        assertNotNull(result);
        verify(citasRepository, times(1)).save(cita);
    }

    @Test
    public void testUpdateCitas() {
        Citas cita = new Citas();
        when(citasRepository.existsById(1L)).thenReturn(true);
        when(citasRepository.save(cita)).thenReturn(cita);

        Citas result = citasService.updateCitas(1L, cita);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(citasRepository, times(1)).existsById(1L);
        verify(citasRepository, times(1)).save(cita);
    }

}

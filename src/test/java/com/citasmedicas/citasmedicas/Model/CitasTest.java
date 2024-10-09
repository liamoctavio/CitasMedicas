package com.citasmedicas.citasmedicas.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CitasTest {

    @Test
    public void testGetId() {
        Citas cita = new Citas();
        cita.setId(1L);
        assertEquals(1L, cita.getId());
    }

    @Test
    public void testSetId() {
        Citas cita = new Citas();
        cita.setId(2L);
        assertEquals(2L, cita.getId());
    }

    @Test
    public void testGetNombrePaciente() {
        Citas cita = new Citas();
        cita.setNombrePaciente("John Doe");
        assertEquals("John Doe", cita.getNombrePaciente());
    }

    @Test
    public void testSetNombrePaciente() {
        Citas cita = new Citas();
        cita.setNombrePaciente("Jane Doe");
        assertEquals("Jane Doe", cita.getNombrePaciente());
    }

}

package com.citasmedicas.citasmedicas.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.citasmedicas.citasmedicas.Model.Citas;
import com.citasmedicas.citasmedicas.Service.CitasService;

import java.util.Arrays;
import java.util.Optional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

public class CitasControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CitasService citasService;

    @InjectMocks
    private CitasController citasController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(citasController).build();
    }

    @Test
    public void testFindAll() throws Exception {
        Citas cita1 = new Citas();
        Citas cita2 = new Citas();
        when(citasService.findAll()).thenReturn(Arrays.asList(cita1, cita2));

        mockMvc.perform(get("/citas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists());

        verify(citasService, times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        Citas cita = new Citas();
        cita.setId(1L); 
        when(citasService.findById(1L)).thenReturn(Optional.of(cita));

        mockMvc.perform(get("/citas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L)); 

        verify(citasService, times(1)).findById(1L);
    }

    @Test
    public void testSave() throws Exception {
        Citas cita = new Citas();
        cita.setId(1L); 
        when(citasService.save(any(Citas.class))).thenReturn(cita);

        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombrePaciente\":\"John Doe\",\"fechaCita\":\"2023-10-10\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L)); 

        verify(citasService, times(1)).save(any(Citas.class));
    }

    @Test
    public void testUpdateCitas() throws Exception {
        Citas cita = new Citas();
        cita.setId(1L); 
        when(citasService.updateCitas(eq(1L), any(Citas.class))).thenReturn(cita);

        mockMvc.perform(put("/citas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombrePaciente\":\"John Doe\",\"fechaCita\":\"2023-10-10\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L)); 

        verify(citasService, times(1)).updateCitas(eq(1L), any(Citas.class));
    }


}

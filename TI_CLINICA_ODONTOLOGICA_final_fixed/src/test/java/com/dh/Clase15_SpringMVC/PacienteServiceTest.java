package com.dh.TI_Clinica_Odontologica.service;

import com.dh.TI_Clinica_Odontologica.entity.Paciente;
import com.dh.TI_Clinica_Odontologica.repository.IPacienteRepository;
import com.dh.TI_Clinica_Odontologica.service.impl.PacienteServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PacienteServiceTest {

    @Mock
    private IPacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteServicioImpl pacienteServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarPaciente() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Paciente savedPaciente = pacienteServicio.guardar(paciente);

        assertEquals(1L, savedPaciente.getId());
        verify(pacienteRepository, times(1)).save(paciente);
    }

    @Test
    void testBuscarPorId() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        Paciente foundPaciente = pacienteServicio.buscarPorId(1L);

        assertEquals(1L, foundPaciente.getId());
        verify(pacienteRepository, times(1)).findById(1L);
    }

    @Test
    void testEliminarPaciente() {
        Long pacienteId = 1L;

        pacienteServicio.eliminar(pacienteId);

        verify(pacienteRepository, times(1)).deleteById(pacienteId);
    }
}


package com.dh.TI_Clinica_Odontologica.service;

import com.dh.TI_Clinica_Odontologica.entity.Turno;
import com.dh.TI_Clinica_Odontologica.repository.ITurnoRepository;
import com.dh.TI_Clinica_Odontologica.service.impl.TurnoServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TurnoServiceTest {

    @Mock
    private ITurnoRepository turnoRepository;

    @InjectMocks
    private TurnoServicioImpl turnoServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarTurno() {
        Turno turno = new Turno();
        turno.setId(1L);
        when(turnoRepository.save(turno)).thenReturn(turno);

        Turno savedTurno = turnoServicio.guardar(turno);

        assertEquals(1L, savedTurno.getId());
        verify(turnoRepository, times(1)).save(turno);
    }

    @Test
    void testBuscarPorId() {
        Turno turno = new Turno();
        turno.setId(1L);
        when(turnoRepository.findById(1L)).thenReturn(Optional.of(turno));

        Turno foundTurno = turnoServicio.buscarPorId(1L);

        assertEquals(1L, foundTurno.getId());
        verify(turnoRepository, times(1)).findById(1L);
    }

    @Test
    void testEliminarTurno() {
        Long turnoId = 1L;

        turnoServicio.eliminar(turnoId);

        verify(turnoRepository, times(1)).deleteById(turnoId);
    }
}

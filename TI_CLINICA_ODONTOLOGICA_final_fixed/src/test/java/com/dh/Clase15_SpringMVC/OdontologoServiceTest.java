package com.dh.TI_Clinica_Odontologica.service;

import com.dh.TI_Clinica_Odontologica.entity.Odontologo;
import com.dh.TI_Clinica_Odontologica.repository.IOdontologoRepository;
import com.dh.TI_Clinica_Odontologica.service.impl.OdontologoServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OdontologoServiceTest {

    @Mock
    private IOdontologoRepository odontologoRepository;

    @InjectMocks
    private OdontologoServicioImpl odontologoServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarOdontologo() {
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        when(odontologoRepository.save(odontologo)).thenReturn(odontologo);

        Odontologo savedOdontologo = odontologoServicio.guardar(odontologo);

        assertEquals(1L, savedOdontologo.getId());
        verify(odontologoRepository, times(1)).save(odontologo);
    }

    @Test
    void testBuscarPorId() {
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        when(odontologoRepository.findById(1L)).thenReturn(Optional.of(odontologo));

        Odontologo foundOdontologo = odontologoServicio.buscarPorId(1L);

        assertEquals(1L, foundOdontologo.getId());
        verify(odontologoRepository, times(1)).findById(1L);
    }

    @Test
    void testEliminarOdontologo() {
        Long odontologoId = 1L;

        odontologoServicio.eliminar(odontologoId);

        verify(odontologoRepository, times(1)).deleteById(odontologoId);
    }
}

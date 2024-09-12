
package com.dh.TI_Clinica_Odontologica.service;

import com.dh.TI_Clinica_Odontologica.entity.Turno;

import java.util.List;

public interface ITurnoServicio {
    Turno guardar(Turno turno);
    Turno buscarPorId(Long id);
    List<Turno> listarTodos();
    void eliminar(Long id);
    
    // Métodos agregados
    List<Turno> buscarPorPacienteId(Long pacienteId);
    List<Turno> buscarPorOdontologoId(Long odontologoId);
}


package com.dh.TI_Clinica_Odontologica.service.impl;

import com.dh.TI_Clinica_Odontologica.entity.Turno;
import com.dh.TI_Clinica_Odontologica.repository.ITurnoRepository;
import com.dh.TI_Clinica_Odontologica.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicioImpl implements ITurnoServicio {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Override
    public Turno guardar(Turno turno) {
        //lógica
        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        Optional<Turno> turnoBuscado =  iTurnoRepository.findById(id);
        return turnoBuscado.orElse(null);
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }

    // Eliminar turno
    @Override
    public void eliminar(Long id) {
        iTurnoRepository.deleteById(id);
    }

    // Buscar turnos por paciente ID
    @Override
    public List<Turno> buscarPorPacienteId(Long pacienteId) {
        return iTurnoRepository.findByPacienteId(pacienteId);
    }

    // Buscar turnos por odontologo ID
    @Override
    public List<Turno> buscarPorOdontologoId(Long odontologoId) {
        return iTurnoRepository.findByOdontologoId(odontologoId);
    }

}

package com.dh.TI_Clinica_Odontologica.service.impl;

import com.dh.TI_Clinica_Odontologica.entity.Turno;
import com.dh.TI_Clinica_Odontologica.entity.Paciente;
import com.dh.TI_Clinica_Odontologica.entity.Odontologo;
import com.dh.TI_Clinica_Odontologica.repository.ITurnoRepository;
import com.dh.TI_Clinica_Odontologica.repository.IPacienteRepository;  // Importación necesaria
import com.dh.TI_Clinica_Odontologica.repository.IOdontologoRepository;  // Importación necesaria
import com.dh.TI_Clinica_Odontologica.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicioImpl implements ITurnoServicio {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;  // Inyección del repositorio de Paciente

    @Autowired
    private IOdontologoRepository odontologoRepository;  // Inyección del repositorio de Odontologo

    @Override
    public Turno guardar(Turno turno) {
        if (turno.getPaciente() == null || turno.getOdontologo() == null) {
            throw new IllegalArgumentException("El turno debe tener un paciente y un odontologo asignados");
        }

        Optional<Paciente> paciente = pacienteRepository.findById(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoRepository.findById(turno.getOdontologo().getId());

        turno.setPaciente(paciente.get());
        turno.setOdontologo(odontologo.get());

        // Cambiar turnoRepository por iTurnoRepository
        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        Optional<Turno> turnoBuscado = iTurnoRepository.findById(id);
        return turnoBuscado.orElse(null);
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        iTurnoRepository.deleteById(id);
    }

    @Override
    public List<Turno> buscarPorPacienteId(Long pacienteId) {
        return iTurnoRepository.findByPacienteId(pacienteId);
    }

    @Override
    public List<Turno> buscarPorOdontologoId(Long odontologoId) {
        return iTurnoRepository.findByOdontologoId(odontologoId);
    }
}

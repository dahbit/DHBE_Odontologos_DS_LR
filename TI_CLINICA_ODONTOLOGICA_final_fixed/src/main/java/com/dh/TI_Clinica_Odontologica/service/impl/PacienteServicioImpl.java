package com.dh.TI_Clinica_Odontologica.service.impl;

import com.dh.TI_Clinica_Odontologica.entity.Paciente;
import com.dh.TI_Clinica_Odontologica.repository.IPacienteRepository;
import com.dh.TI_Clinica_Odontologica.service.IPacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicioImpl implements IPacienteServicio {

    @Autowired
    private IPacienteRepository iPacienteRepository;



    @Override
    public Paciente guardar(Paciente paciente) {
        return iPacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        Optional<Paciente> pacienteBuscado = iPacienteRepository.findById(id);
        if(!pacienteBuscado.isPresent())  {
            return null;
        } else {
            return pacienteBuscado.get();
        }

    }

    @Override
    public List<Paciente> listarTodos() {
        return iPacienteRepository.findAll();
    }

    @Override
    public void actualizar(Paciente paciente) {
        iPacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        iPacienteRepository.deleteById(id);
    }
}

package com.dh.Clase15_SpringMVC.service.impl;

import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.repository.ITurnoRepository;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServicioImpl implements ITurnoServicio {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Override
    public Turno guardar(Turno turno) {
        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        return iTurnoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }

    @Override
    public void actualizar(Turno entity) {

    }

    @Override
    public void eliminar(Long aLong) {

    }
}

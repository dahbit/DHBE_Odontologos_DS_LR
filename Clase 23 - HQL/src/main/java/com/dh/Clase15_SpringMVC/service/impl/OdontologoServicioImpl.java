package com.dh.Clase15_SpringMVC.service.impl;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.repository.IOdontologoRepository;
import com.dh.Clase15_SpringMVC.service.IOdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServicioImpl implements IOdontologoServicio {

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Long id) {
        return iOdontologoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return iOdontologoRepository.findAll();
    }

    @Override
    public Odontologo buscarPorMatricula(String matricula) {
        return iOdontologoRepository.findByMatricula(matricula);
    }
}

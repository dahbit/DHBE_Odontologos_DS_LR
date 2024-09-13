package com.dh.TI_Clinica_Odontologica.service;

import com.dh.TI_Clinica_Odontologica.entity.Odontologo;
import com.dh.TI_Clinica_Odontologica.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoServicio {
    Odontologo guardar (Odontologo odontologo);
    Odontologo buscarPorId(Long id) throws ResourceNotFoundException;
    void eliminar(Long id);
    void actualizar (Odontologo odontologo);

    List<Odontologo> listarTodos();

    Odontologo buscarPorMatricula(String matricula);
}

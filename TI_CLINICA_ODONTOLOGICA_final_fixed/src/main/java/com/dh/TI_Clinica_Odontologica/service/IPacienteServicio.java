package com.dh.TI_Clinica_Odontologica.service;

import com.dh.TI_Clinica_Odontologica.entity.Paciente;

import java.util.List;

public interface IPacienteServicio {
    //CRUD - ABM
    Paciente guardar (Paciente paciente);
    Paciente buscarPorId(Long id);
    List<Paciente> listarTodos();
    void actualizar(Paciente paciente);
    void eliminar(Long id);


}

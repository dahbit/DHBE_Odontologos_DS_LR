package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.entity.Odontologo;

public interface IOdontologoServicio extends ICRUDService<Odontologo, Long> {
    Odontologo buscarPorMatricula(String matricula);
}

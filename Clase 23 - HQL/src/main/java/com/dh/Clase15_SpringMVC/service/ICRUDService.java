package com.dh.Clase15_SpringMVC.service;

import java.util.List;

public interface ICRUDService<T, ID> {
    T guardar(T entity);
    T buscarPorId(ID id);
    List<T> listarTodos();
    void actualizar(T entity);
    void eliminar(ID id);
}

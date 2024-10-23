package com.ejercicio.practica.service;

import com.ejercicio.practica.model.Privilegio;

import java.util.List;
import java.util.Optional;

public interface PrivilegioService {
    List<Privilegio> obtenerTodos();
    Optional<Privilegio> obtenerPorId(Long id);
    Privilegio crear(Privilegio privilegio);
    Privilegio actualizar(Long id, Privilegio privilegio);
    void eliminar(Long id);
}

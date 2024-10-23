package com.ejercicio.practica.service.impl;

import com.ejercicio.practica.model.Privilegio;
import com.ejercicio.practica.repository.PrivilegioRepository;
import com.ejercicio.practica.service.PrivilegioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegioServiceImpl  implements PrivilegioService {

    private final PrivilegioRepository privilegioRepository;

    public PrivilegioServiceImpl(PrivilegioRepository privilegioRepository) {
        this.privilegioRepository = privilegioRepository;
    }

    @Override
    public List<Privilegio> obtenerTodos() {
        return privilegioRepository.findAll();
    }

    @Override
    public Optional<Privilegio> obtenerPorId(Long id) {
        return privilegioRepository.findById(id);
    }

    @Override
    public Privilegio crear(Privilegio privilegio) {
        return privilegioRepository.save(privilegio);
    }

    @Override
    public Privilegio actualizar(Long id, Privilegio privilegio) {
        if (privilegioRepository.existsById(id)) {
            privilegio.setId(id);
            return privilegioRepository.save(privilegio);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        privilegioRepository.deleteById(id);
    }
}

package com.ejercicio.practica.service.impl;

import com.ejercicio.practica.model.Role;
import com.ejercicio.practica.repository.RoleRepository;
import com.ejercicio.practica.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> obtenerTodos() {
        return roleRepository.findAll();
    }

    public Optional<Role> obtenerPorId(Long id) {
        return roleRepository.findById(id);
    }

    public Role crear(Role rol) {
        return roleRepository.save(rol);
    }

    public Role actualizar(Long id, Role rol) {
        if (roleRepository.existsById(id)) {
            rol.setId(id);
            return roleRepository.save(rol);
        }
        return null;
    }

    public void eliminar(Long id) {
        roleRepository.deleteById(id);
    }
}

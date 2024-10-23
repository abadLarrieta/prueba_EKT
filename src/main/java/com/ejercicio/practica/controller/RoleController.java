package com.ejercicio.practica.controller;

import com.ejercicio.practica.model.Role;
import com.ejercicio.practica.service.impl.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleServiceImpl roleServiceImpl;

    public RoleController(RoleServiceImpl roleServiceImpl) {
        this.roleServiceImpl = roleServiceImpl;
    }

    // Obtener todos los roles
    @GetMapping
    public List<Role> obtenerTodos() {
        return roleServiceImpl.obtenerTodos();
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> obtenerPorId(@PathVariable Long id) {
        Optional<Role> rol = roleServiceImpl.obtenerPorId(id);
        return rol.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<Role> crear(@RequestBody Role rol) {
        Role nuevoRol = roleServiceImpl.crear(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    // Actualizar un rol existente
    @PutMapping("/{id}")
    public ResponseEntity<Role> actualizar(@PathVariable Long id, @RequestBody Role rol) {
        Role rolActualizado = roleServiceImpl.actualizar(id, rol);
        if (rolActualizado != null) {
            return ResponseEntity.ok(rolActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (roleServiceImpl.obtenerPorId(id).isPresent()) {
            roleServiceImpl.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

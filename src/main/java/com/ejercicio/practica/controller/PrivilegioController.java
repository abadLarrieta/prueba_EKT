package com.ejercicio.practica.controller;

import com.ejercicio.practica.model.Privilegio;
import com.ejercicio.practica.service.impl.PrivilegioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/privilegios")
public class PrivilegioController {

    private final PrivilegioServiceImpl privilegioServiceImpl;

    public PrivilegioController(PrivilegioServiceImpl privilegioServiceImpl) {
        this.privilegioServiceImpl = privilegioServiceImpl;
    }

    // Obtener todos los privilegios
    @GetMapping
    public List<Privilegio> obtenerTodos() {
        return privilegioServiceImpl.obtenerTodos();
    }

    // Obtener un privilegio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Privilegio> obtenerPorId(@PathVariable Long id) {
        Optional<Privilegio> privilegio = privilegioServiceImpl.obtenerPorId(id);
        return privilegio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo privilegio
    @PostMapping
    public ResponseEntity<Privilegio> crear(@RequestBody Privilegio privilegio) {
        Privilegio nuevoPrivilegio = privilegioServiceImpl.crear(privilegio);
        return ResponseEntity.ok(nuevoPrivilegio);
    }

    // Actualizar un privilegio existente
    @PutMapping("/{id}")
    public ResponseEntity<Privilegio> actualizar(@PathVariable Long id, @RequestBody Privilegio privilegio) {
        Privilegio privilegioActualizado = privilegioServiceImpl.actualizar(id, privilegio);
        if (privilegioActualizado != null) {
            return ResponseEntity.ok(privilegioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un privilegio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (privilegioServiceImpl.obtenerPorId(id).isPresent()) {
            privilegioServiceImpl.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

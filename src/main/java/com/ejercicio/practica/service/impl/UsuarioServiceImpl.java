package com.ejercicio.practica.service.impl;


import com.ejercicio.practica.model.Usuario;
import com.ejercicio.practica.repository.UsuarioRepository;
import com.ejercicio.practica.service.PlanetService;
import com.ejercicio.practica.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PlanetService planetService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PlanetService planetService) {
        this.usuarioRepository = usuarioRepository;
        this.planetService = planetService;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuariosList = usuarioRepository.findAll();
        usuariosList.forEach(user -> user.setEdad(usuarioRepository.calculateAgeUser(user.getId())));
        return usuariosList;
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.setEdad(usuarioRepository.calculateAgeUser(usuario.getId()));
        return Optional.of(usuario);
    }

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setNombrePlaneta( obtenerNombrePlanetaAleatorio());
        Usuario savedUser = usuarioRepository.save(usuario);
        savedUser.setEdad(usuarioRepository.calculateAgeUser(usuario.getId()));
        return savedUser;
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            Usuario updatedUser =  usuarioRepository.save(usuario);
            updatedUser.setEdad(usuarioRepository.calculateAgeUser(usuario.getId()));
            return updatedUser;
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    private String obtenerNombrePlanetaAleatorio() {
        int idPlaneta = (int) (Math.random() * 50) + 1;
        return planetService.getPlanetById(idPlaneta).getResult().getProperties().getName();
    }
}

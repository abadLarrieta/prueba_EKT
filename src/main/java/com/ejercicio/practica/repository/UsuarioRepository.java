package com.ejercicio.practica.repository;


import com.ejercicio.practica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Procedure("calculate_age_user")
    String calculateAgeUser(Long id);
}

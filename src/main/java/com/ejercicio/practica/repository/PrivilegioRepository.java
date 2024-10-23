package com.ejercicio.practica.repository;

import com.ejercicio.practica.model.Privilegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Long> {

}

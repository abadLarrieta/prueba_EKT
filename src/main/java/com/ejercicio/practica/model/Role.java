package com.ejercicio.practica.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Instant fechaCreacion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_actualizacion", insertable = false)
    private Instant fechaActualizacion;

    @ColumnDefault("true")
    @Column(name = "ind_activo", nullable = false)
    private Boolean indActivo = false;

    @OneToMany(mappedBy = "rol")
    @JsonManagedReference
    private List<Privilegio> privilegios = new ArrayList<>();

}
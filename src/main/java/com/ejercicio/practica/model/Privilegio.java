package com.ejercicio.practica.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "privilegios")
public class Privilegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruta_recurso", nullable = false)
    private String rutaRecurso;

    @Column(name = "metodo_http", nullable = false)
    private String metodoHttp;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Instant fechaCreacion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_actualizacion", insertable = false)
    private Instant fechaActualizacion;

    @ColumnDefault("true")
    @Column(name = "ind_activo", nullable = false)
    private Boolean indActivo = false;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    @JsonBackReference
    private Role rol;

}
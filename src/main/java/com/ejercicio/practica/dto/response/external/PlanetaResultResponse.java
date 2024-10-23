package com.ejercicio.practica.dto.response.external;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlanetaResultResponse implements Serializable {

    PlanetaPropertiesResponse properties;
    private String description;
    private String _id;
    private String uid;
    private Integer __v;
}

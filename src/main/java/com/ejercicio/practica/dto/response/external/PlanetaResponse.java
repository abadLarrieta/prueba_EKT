package com.ejercicio.practica.dto.response.external;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlanetaResponse implements Serializable {

    private String message;
    private PlanetaResultResponse result;
}

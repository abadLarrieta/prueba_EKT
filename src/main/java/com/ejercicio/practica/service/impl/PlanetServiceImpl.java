package com.ejercicio.practica.service.impl;


import com.ejercicio.practica.dto.response.external.PlanetaResponse;
import com.ejercicio.practica.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PlanetaResponse getPlanetById(Integer id) {
        String url = "https://www.swapi.tech/api/planets/" + id;
        return restTemplate.getForObject(url, PlanetaResponse.class);
    }


}

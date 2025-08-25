package com.stephania.audit.service;

import com.stephania.audit.entity.Municipio;
import com.stephania.audit.repository.MunicipioRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Cacheable("municipios")
    public List<Municipio> obtenerTodos() {
        return municipioRepository.findAllByOrderByNombreAsc();
    }
}

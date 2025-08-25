package com.stephania.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephania.audit.entity.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    List<Municipio> findAllByOrderByNombreAsc();
}
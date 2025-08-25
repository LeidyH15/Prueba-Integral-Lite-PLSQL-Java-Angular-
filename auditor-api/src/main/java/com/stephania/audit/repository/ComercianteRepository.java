package com.stephania.audit.repository;

import com.stephania.audit.entity.Comerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComercianteRepository extends JpaRepository<Comerciante, Long>, JpaSpecificationExecutor<Comerciante> {

    @Query("SELECT DISTINCT c.municipio FROM Comerciante c WHERE c.municipio IS NOT NULL")
    List<String> findDistinctMunicipios();
}
package com.stephania.audit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.stephania.audit.dto.ComercianteRequestDTO;
import com.stephania.audit.dto.ComercianteResponseDTO;
import com.stephania.audit.entity.Comerciante;
import com.stephania.audit.repository.ComercianteRepository;


@Service
public class ComercianteService {

    @Autowired
    private ComercianteRepository repository;

    public ComercianteResponseDTO crear(ComercianteRequestDTO dto, String usuario) {
        Comerciante comerciante = Comerciante.builder()
            .nombre(dto.getNombre())
            .municipio(dto.getMunicipio())
            .telefono(dto.getTelefono())
            .correo(dto.getCorreo())
            .estado(dto.getEstado())
            .usuarioActualizacion(usuario)
            .build();
        Comerciante guardado = repository.save(comerciante);
        return mapToResponse(guardado);
    }

    public ComercianteResponseDTO actualizar(Long id, ComercianteRequestDTO dto, String usuario) {
        Comerciante comerciante = repository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        comerciante.setNombre(dto.getNombre());
        comerciante.setMunicipio(dto.getMunicipio());
        comerciante.setTelefono(dto.getTelefono());
        comerciante.setCorreo(dto.getCorreo());
        comerciante.setEstado(dto.getEstado());
        comerciante.setUsuarioActualizacion(usuario);
        Comerciante actualizado = repository.save(comerciante);
        return mapToResponse(actualizado);
    }

    public Page<ComercianteResponseDTO> consultarPaginado(String nombre, LocalDate fecha, Boolean estado, Pageable pageable) {
        Specification<Comerciante> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nombre != null) predicates.add(cb.like(cb.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
            if (fecha != null) predicates.add(cb.equal(cb.function("TRUNC", LocalDate.class, root.get("fechaRegistro")), fecha));
            if (estado != null) predicates.add(cb.equal(root.get("estado"), estado));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return repository.findAll(spec, pageable).map(this::mapToResponse);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public ComercianteResponseDTO cambiarEstado(Long id, Boolean nuevoEstado, String usuario) {
        Comerciante comerciante = repository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        comerciante.setEstado(nuevoEstado);
        comerciante.setUsuarioActualizacion(usuario);
        return mapToResponse(repository.save(comerciante));
    }

    private ComercianteResponseDTO mapToResponse(Comerciante c) {
        return ComercianteResponseDTO.builder()
            .id(c.getId())
            .nombre(c.getNombre())
            .municipio(c.getMunicipio())
            .telefono(c.getTelefono())
            .correo(c.getCorreo())
            .estado(c.getEstado())
            .fechaRegistro(c.getFechaRegistro())
            .fechaActualizacion(c.getFechaActualizacion())
            .usuarioActualizacion(c.getUsuarioActualizacion())
            .build();
    }
}

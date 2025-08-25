package com.stephania.audit.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephania.audit.dto.ReporteComercianteDTO;
import com.stephania.audit.entity.Comerciante;
import com.stephania.audit.repository.ComercianteRepository;

@Service
public class ReporteComercianteService {

    @Autowired
    private ComercianteRepository comercianteRepository;

    public List<ReporteComercianteDTO> obtenerReporte() {
        List<Comerciante> activos = comercianteRepository.findByEstadoTrue();

        return activos.stream().map(c -> {
            int cantEst = c.getEstablecimientos().size();
            BigDecimal totalIngresos = c.getEstablecimientos().stream()
                .map(e -> e.getIngresos() != null ? e.getIngresos() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            int totalEmpleados = c.getEstablecimientos().stream()
                .mapToInt(e -> e.getEmpleados() != null ? e.getEmpleados() : 0)
                .sum();

            ReporteComercianteDTO dto = new ReporteComercianteDTO();
            dto.setNombre(c.getNombre());
            dto.setMunicipio(c.getMunicipio());
            dto.setTelefono(c.getTelefono());
            dto.setCorreo(c.getCorreo());
            dto.setFechaRegistro(c.getFechaRegistro());
            dto.setEstado(c.getEstado());
            dto.setCantidadEstablecimientos(cantEst);
            dto.setTotalIngresos(totalIngresos);
            dto.setCantidadEmpleados(totalEmpleados);
            return dto;
        }).collect(Collectors.toList());

    }

    public String generarCsv(List<ReporteComercianteDTO> datos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre|Municipio|Teléfono|Correo|FechaRegistro|Estado|CantEstablecimientos|TotalIngresos|CantEmpleados\n");

        for (ReporteComercianteDTO dto : datos) {
            sb.append(dto.getNombre()).append("|")
              .append(dto.getMunicipio()).append("|")
              .append(dto.getTelefono()).append("|")
              .append(dto.getCorreo()).append("|")
              .append(dto.getFechaRegistro()).append("|")
              .append(dto.getEstado()).append("|")
              .append(dto.getCantidadEstablecimientos()).append("|")
              .append(dto.getTotalIngresos()).append("|")
              .append(dto.getCantidadEmpleados()).append("\n");
        }

        return sb.toString();
    }
}

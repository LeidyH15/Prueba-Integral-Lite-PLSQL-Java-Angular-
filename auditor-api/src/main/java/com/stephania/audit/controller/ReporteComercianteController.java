package com.stephania.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stephania.audit.dto.ApiResponse;
import com.stephania.audit.dto.ReporteComercianteDTO;
import com.stephania.audit.service.ReporteComercianteService;

@RestController
@RequestMapping("/api/reportes")
public class ReporteComercianteController {

    @Autowired
    private ReporteComercianteService service;

    @GetMapping("/comerciantes")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<String>> generarReporteCsv() {
        List<ReporteComercianteDTO> datos = service.obtenerReporte();
        String csv = service.generarCsv(datos);
        return ResponseEntity.ok(new ApiResponse<>(true, "Reporte generado", csv));
    }
}
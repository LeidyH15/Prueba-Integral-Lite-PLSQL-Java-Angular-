package com.stephania.audit.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.stephania.audit.dto.ApiResponse;
import com.stephania.audit.dto.ComercianteRequestDTO;
import com.stephania.audit.dto.ComercianteResponseDTO;
import com.stephania.audit.service.ComercianteService;

@RestController
@RequestMapping("/api/comerciantes")
public class ComercianteController {

    @Autowired
    private ComercianteService service;

    @PostMapping
    public ResponseEntity<ApiResponse<ComercianteResponseDTO>> crear(
        @RequestBody ComercianteRequestDTO dto,
        @AuthenticationPrincipal(expression = "username") String usuario) {

        ComercianteResponseDTO creado = service.crear(dto, usuario);
        return ResponseEntity.ok(new ApiResponse<>(true, "Comerciante creado", creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComercianteResponseDTO>> actualizar(
        @PathVariable Long id,
        @RequestBody ComercianteRequestDTO dto,
        @AuthenticationPrincipal(expression = "username") String usuario) {

        ComercianteResponseDTO actualizado = service.actualizar(id, dto, usuario);
        return ResponseEntity.ok(new ApiResponse<>(true, "Comerciante actualizado", actualizado));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ComercianteResponseDTO>>> consultarPaginado(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) LocalDate fecha,
        @RequestParam(required = false) Boolean estado,
        Pageable pageable) {

        Page<ComercianteResponseDTO> pagina = service.consultarPaginado(nombre, fecha, estado, pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Consulta paginada de comerciantes", pagina));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ComercianteResponseDTO>> consultarPorId(@PathVariable Long id) {
        ComercianteResponseDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Comerciante encontrado", dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<ApiResponse<ComercianteResponseDTO>> cambiarEstado(
        @PathVariable Long id,
        @RequestParam Boolean estado,
        @AuthenticationPrincipal(expression = "username") String usuario) {

        ComercianteResponseDTO actualizado = service.cambiarEstado(id, estado, usuario);
        return ResponseEntity.ok(new ApiResponse<>(true, "Estado actualizado", actualizado));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Comerciante eliminado", null));
    }
}

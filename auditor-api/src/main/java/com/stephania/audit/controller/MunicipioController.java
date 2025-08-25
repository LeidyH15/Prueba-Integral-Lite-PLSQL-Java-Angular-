package com.stephania.audit.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stephania.audit.dto.ApiResponse;
import com.stephania.audit.entity.Municipio;
import com.stephania.audit.service.MunicipioService;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Municipio>>> listarMunicipios() {
        List<Municipio> municipios = municipioService.obtenerTodos();
        ApiResponse<List<Municipio>> respuesta = new ApiResponse<>(true, "Lista de municipios", municipios);
        return ResponseEntity.ok(respuesta);
    }
}
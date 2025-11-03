package com.duoc.labs.controller;


import com.duoc.fslaboratorio.model.Laboratorio;
import com.duoc.labs.dto.CrearLaboratorioDTO;
import com.duoc.labs.service.LaboratorioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/labs/laboratorios")
public class LaboratorioController {

    private final LaboratorioService laboratorioService;

    public LaboratorioController(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    @PostMapping
    public ResponseEntity<Laboratorio> crear(@Valid @RequestBody CrearLaboratorioDTO dto){
        return ResponseEntity.ok(laboratorioService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> obtener(@PathVariable Long id){
        return ResponseEntity.ok(laboratorioService.obtener(id));
    }
}


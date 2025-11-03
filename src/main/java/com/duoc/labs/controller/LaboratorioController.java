// com/duoc/labs/controller/LaboratorioController.java
package com.duoc.labs.controller;

import com.duoc.fslaboratorio.model.Laboratorio;
import com.duoc.labs.dto.CrearLaboratorioDTO;
import com.duoc.labs.service.LaboratorioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/labs") // 👈 base más simple
public class LaboratorioController {

    private final LaboratorioService laboratorioService;

    public LaboratorioController(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    // POST /api/labs/laboratorios
    @PostMapping("/laboratorios")
    public ResponseEntity<Laboratorio> crear(@Valid @RequestBody CrearLaboratorioDTO dto){
        Laboratorio l = laboratorioService.crear(dto);
        return ResponseEntity.created(URI.create("/api/labs/laboratorios/" + l.getIdLaboratorio()))
                             .body(l);
    }

    // GET /api/labs/laboratorios/{id}
    @GetMapping("/laboratorios/{id}")
    public ResponseEntity<Laboratorio> obtener(@PathVariable Long id){
        return ResponseEntity.ok(laboratorioService.obtener(id));
    }

    // ✅ GET /api/labs/laboratorios (listar todos)
    @GetMapping("/laboratorios")
    public ResponseEntity<List<Laboratorio>> listar(){
        return ResponseEntity.ok(laboratorioService.listarTodos());
    }

    // (Opcional) Alias para raíz:
    // ✅ GET /api/labs  → lista de labs
    @GetMapping
    public ResponseEntity<List<Laboratorio>> listarEnRaiz(){
        return ResponseEntity.ok(laboratorioService.listarTodos());
    }
}

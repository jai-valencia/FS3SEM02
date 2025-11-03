package com.duoc.labs.controller;


import com.duoc.fslaboratorio.model.AsignacionLaboratorio;
import com.duoc.fslaboratorio.model.OrdenAnalisis;
import com.duoc.labs.dto.AsignarAnalisisDTO;
import com.duoc.labs.dto.CambiarEstadoAsignacionDTO;
import com.duoc.labs.dto.CrearOrdenDTO;
import com.duoc.labs.service.OrdenAsignacionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/labs")
public class OrdenAsignacionController {

    private final OrdenAsignacionService service;

    public OrdenAsignacionController(OrdenAsignacionService service) {
        this.service = service;
    }

    @PostMapping("/ordenes")
    public ResponseEntity<OrdenAnalisis> crearOrden(@Valid @RequestBody CrearOrdenDTO dto){
        return ResponseEntity.ok(service.crearOrden(dto));
    }

    @PostMapping("/asignaciones")
    public ResponseEntity<AsignacionLaboratorio> asignarAnalisis(@Valid @RequestBody AsignarAnalisisDTO dto){
        return ResponseEntity.ok(service.asignarAnalisis(dto));
    }

    @PutMapping("/asignaciones/estado")
    public ResponseEntity<AsignacionLaboratorio> cambiarEstado(@Valid @RequestBody CambiarEstadoAsignacionDTO dto){
        return ResponseEntity.ok(service.cambiarEstado(dto));
    }
}


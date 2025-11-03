package com.duoc.labs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CambiarEstadoOrdenDTO {
    @NotBlank @Size(max = 20)
    private String nuevoEstado; // PENDIENTE/ASIGNADA/EN_PROCESO/FINALIZADA/CANCELADA

    public String getNuevoEstado() { return nuevoEstado; }
    public void setNuevoEstado(String nuevoEstado) { this.nuevoEstado = nuevoEstado; }
}


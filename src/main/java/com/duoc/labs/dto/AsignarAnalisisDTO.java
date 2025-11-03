package com.duoc.labs.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AsignarAnalisisDTO {
    @NotNull private Long idOrdenAnalisis;
    @NotBlank @Size(max=30) private String codigoLaboratorio; // se buscará por código
    @NotBlank @Size(max=30) private String codigoTipoAnalisis; // se buscará por código
    @Size(max=10) private String prioridad; // BAJA/MEDIA/ALTA
    // getters/setters

    public Long getIdOrdenAnalisis() {
        return idOrdenAnalisis;
    }
    public void setIdOrdenAnalisis(Long idOrdenAnalisis) {
        this.idOrdenAnalisis = idOrdenAnalisis;
    }
    public String getCodigoLaboratorio() {
        return codigoLaboratorio;
    }
    public void setCodigoLaboratorio(String codigoLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
    }
    public String getCodigoTipoAnalisis() {
        return codigoTipoAnalisis;
    }
    public void setCodigoTipoAnalisis(String codigoTipoAnalisis) {
        this.codigoTipoAnalisis = codigoTipoAnalisis;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
        
}


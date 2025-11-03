package com.duoc.labs.repository;


import com.duoc.fslaboratorio.model.OrdenAnalisis;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenAnalisisRepository extends JpaRepository<OrdenAnalisis, Long> {
     List<OrdenAnalisis> findByEstadoIgnoreCase(String estado);
    List<OrdenAnalisis> findByPaciente_Rut(String rutPaciente);
    List<OrdenAnalisis> findByFechaSolicitudBetween(LocalDateTime desde, LocalDateTime hasta);

}


// com/tuapp/labs/repository/PacienteRepository.java
package com.duoc.labs.repository;

import com.duoc.fslaboratorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByRut(String rut);
}

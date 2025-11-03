// com/tuapp/labs/repository/TipoAnalisisRepository.java
package com.duoc.labs.repository;

import com.duoc.fslaboratorio.model.TipoAnalisis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoAnalisisRepository extends JpaRepository<TipoAnalisis, Long> {
    Optional<TipoAnalisis> findByCodigo(String codigo);
}


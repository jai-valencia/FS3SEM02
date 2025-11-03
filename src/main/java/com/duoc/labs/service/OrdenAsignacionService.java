package com.duoc.labs.service;


import com.duoc.fslaboratorio.model.*;
import com.duoc.labs.dto.AsignarAnalisisDTO;
import com.duoc.labs.dto.CambiarEstadoAsignacionDTO;
import com.duoc.labs.dto.CrearOrdenDTO;
import com.duoc.labs.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class OrdenAsignacionService {

    private final PacienteRepository pacienteRepo;
    private final OrdenAnalisisRepository ordenRepo;
    private final LaboratorioRepository labRepo;
    private final TipoAnalisisRepository tipoRepo;
    private final AsignacionLaboratorioRepository asignRepo;

    public OrdenAsignacionService(PacienteRepository pacienteRepo, OrdenAnalisisRepository ordenRepo,
                                  LaboratorioRepository labRepo, TipoAnalisisRepository tipoRepo,
                                  AsignacionLaboratorioRepository asignRepo) {
        this.pacienteRepo = pacienteRepo;
        this.ordenRepo = ordenRepo;
        this.labRepo = labRepo;
        this.tipoRepo = tipoRepo;
        this.asignRepo = asignRepo;
    }

    public OrdenAnalisis crearOrden(CrearOrdenDTO dto){
        Paciente p = pacienteRepo.findByRut(dto.getRutPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Paciente no encontrado por RUT"));

        OrdenAnalisis oa = new OrdenAnalisis();
        oa.setPaciente(p);
        oa.setFechaSolicitud(LocalDateTime.now());
        oa.setEstado("PENDIENTE");
        oa.setMedicoSolicitante(dto.getMedicoSolicitante());
        oa.setObservaciones(dto.getObservaciones());
        return ordenRepo.save(oa);
    }

    public AsignacionLaboratorio asignarAnalisis(AsignarAnalisisDTO dto){
        OrdenAnalisis orden = ordenRepo.findById(dto.getIdOrdenAnalisis())
                .orElseThrow(() -> new EntityNotFoundException("Orden no encontrada"));
        Laboratorio lab = labRepo.findByCodigo(dto.getCodigoLaboratorio())
                .orElseThrow(() -> new EntityNotFoundException("Laboratorio no encontrado por código"));
        TipoAnalisis tipo = tipoRepo.findByCodigo(dto.getCodigoTipoAnalisis())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de análisis no encontrado por código"));

        AsignacionLaboratorio asig = new AsignacionLaboratorio();
        asig.setOrdenAnalisis(orden);
        asig.setLaboratorio(lab);
        asig.setTipoAnalisis(tipo);
        asig.setFechaAsignacion(LocalDateTime.now());
        asig.setEstado("ASIGNADA");
        asig.setPrioridad(dto.getPrioridad()==null ? "MEDIA" : dto.getPrioridad());

        // opcional: si estaba PENDIENTE, pásala a ASIGNADA
        if ("PENDIENTE".equalsIgnoreCase(orden.getEstado())){
            orden.setEstado("ASIGNADA");
        }
        return asignRepo.save(asig);
    }

    public AsignacionLaboratorio cambiarEstado(CambiarEstadoAsignacionDTO dto){
        AsignacionLaboratorio a = asignRepo.findById(dto.getIdAsignacion())
                .orElseThrow(() -> new EntityNotFoundException("Asignación no encontrada"));
        a.setEstado(dto.getEstado());
        // si finaliza, podrías marcar la orden COMPLETADA si todas sus asignaciones finalizaron
        return a; // JPA hace flush al terminar la transacción
    }
}


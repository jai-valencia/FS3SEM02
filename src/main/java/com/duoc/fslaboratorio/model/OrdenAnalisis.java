package com.duoc.fslaboratorio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDENES_ANALISIS")
public class OrdenAnalisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEN_ANALISIS")
    private Long idOrdenAnalisis;

    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE", nullable = false)
    private Paciente paciente;

    @Column(name = "FECHA_SOLICITUD", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;

    @Column(name = "MEDICO_SOLICITANTE", length = 150)
    private String medicoSolicitante;

    @Column(name = "OBSERVACIONES", length = 400)
    private String observaciones;

    @OneToMany(mappedBy = "ordenAnalisis")
    private List<AsignacionLaboratorio> asignaciones;

    // Getters y setters
}

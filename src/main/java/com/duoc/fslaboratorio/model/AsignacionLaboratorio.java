package com.duoc.fslaboratorio.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ASIGNACIONES_LABORATORIO")
public class AsignacionLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASIGNACION")
    private Long idAsignacion;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEN_ANALISIS", nullable = false)
    private OrdenAnalisis ordenAnalisis;

    @ManyToOne
    @JoinColumn(name = "ID_LABORATORIO", nullable = false)
    private Laboratorio laboratorio;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_ANALISIS", nullable = false)
    private TipoAnalisis tipoAnalisis;

    @Column(name = "FECHA_ASIGNACION")
    private LocalDateTime fechaAsignacion;

    @Column(name = "ESTADO", length = 20)
    private String estado;

    @Column(name = "PRIORIDAD", length = 10)
    private String prioridad;

    @OneToMany(mappedBy = "asignacion")
    private List<ResultadoAnalisis> resultados;

    // Getters y setters
}

package com.duoc.fslaboratorio.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPOS_ANALISIS")
public class TipoAnalisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_ANALISIS")
    private Long idTipoAnalisis;

    @Column(name = "NOMBRE", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "CODIGO", nullable = false, unique = true, length = 30)
    private String codigo;

    @Column(name = "UNIDAD_MEDIDA", length = 30)
    private String unidadMedida;

    @Column(name = "RANGO_REFERENCIA", length = 80)
    private String rangoReferencia;

    @OneToMany(mappedBy = "tipoAnalisis")
    private List<AsignacionLaboratorio> asignaciones;

    // Getters y setters
}


package com.duoc.fslaboratorio.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LABORATORIOS")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LABORATORIO")
    private Long idLaboratorio;

    @Column(name = "NOMBRE", nullable = false, unique = true, length = 120)
    private String nombre;

    @Column(name = "CODIGO", nullable = false, unique = true, length = 30)
    private String codigo;

    @Column(name = "DIRECCION", length = 200)
    private String direccion;

    @Column(name = "TELEFONO", length = 30)
    private String telefono;

    @Column(name = "ESTADO", length = 20)
    private String estado;

    @OneToMany(mappedBy = "laboratorio")
    private List<AsignacionLaboratorio> asignaciones;

    // Getters y setters
}


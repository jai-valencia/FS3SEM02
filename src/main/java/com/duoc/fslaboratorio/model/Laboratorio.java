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

    public Laboratorio() {}

    public Long getIdLaboratorio() { return idLaboratorio; }
    public void setIdLaboratorio(Long idLaboratorio) { this.idLaboratorio = idLaboratorio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<AsignacionLaboratorio> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(List<AsignacionLaboratorio> asignaciones) { this.asignaciones = asignaciones; }
}

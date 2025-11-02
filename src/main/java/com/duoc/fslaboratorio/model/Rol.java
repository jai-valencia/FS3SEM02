package com.duoc.fslaboratorio.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private Long idRol;

    @Column(name = "NOMBRE_ROL", nullable = false, unique = true, length = 50)
    private String nombreRol;

    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;

    // Getters y setters
}


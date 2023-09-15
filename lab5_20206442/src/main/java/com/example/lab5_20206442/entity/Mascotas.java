package com.example.lab5_20206442.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "mascotas")
public class Mascotas {

    @Id
    @Column(name="idMascotas")
    private Integer idMascotas;

    @Column(name="nombre_mascota")
    private String nombre_mascota;
    @Column(name="genero")
    private String genero;

    @Column(name="edad")
    private String edad;
    @Column(name="fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name="Vacunado")
    private String Vacunado;
    @Column(name="Desparasitado")
    private String Desparasitado;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona Persona_idPersona;



}
